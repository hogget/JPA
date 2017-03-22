package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.dao.ProjectHistoryDao;
import com.capgemini.domain.Project;
import com.capgemini.domain.ProjectHistory;
import com.capgemini.domain.Worker;

@Repository
public class ProjectHistoryDaoImpl extends AbstractDao<ProjectHistory, Long> implements ProjectHistoryDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public ProjectHistory findByWorkerAndProject(Worker worker, Project project) {

		TypedQuery<ProjectHistory> query = entityManager.createQuery(
				"SELECT p FROM ProjectHistory p JOIN p.worker w JOIN p.project pr  WHERE w.id = :workerId and pr.id = :projectId",
				ProjectHistory.class);
		query.setParameter("workerId", worker.getId());
		query.setParameter("projectId", project.getId());
		List<ProjectHistory> resultList = query.getResultList();
		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public List<Worker> findActiveWorkersInProject(Project project) {
		TypedQuery<Worker> query = entityManager.createQuery(
				"SELECT ph.worker FROM ProjectHistory WHERE ph.dateFrom <= CURDATE() and (ph.dateTo >= CURDATE OR ph.dateTo IS NOT NULL) and ph.project.id = :projectId   ",
				Worker.class);
		query.setParameter("projectId", project.getId());
		List<Worker> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<Worker> findWorkersInProjectFromLastNMonth(Project project, int numberMonth) {
		String sql = " SELECT w.* FROM (SELECT id_worker, dateFrom CASE WHEN dateTo IS NULL OR dateTo > CURDATE() THEN CURDATE() ELSE dateTo END AS dateTo FROM ProjectHistory WHERE project.id = :projectID) AS z "                                                                                        
				+ " INNER JOIN worker w ON w.id = z.id_worker GROUP BY w.id HAVING SUM (TIMESTAMPDIFF(month, dateFrom, dateTo)) > :numberMonth";
		MapSqlParameterSource projectAndNbMonths = new MapSqlParameterSource("projectID", project.getId());
		projectAndNbMonths.addValue("numberMonths", numberMonth);
		List<Worker> workers = jdbcTemplate.query(sql, projectAndNbMonths, new WorkerResultMapper());
		
		if (workers != null && workers.size() > 0) {
			return workers;
		}
		return null;
	}
	
	

}
