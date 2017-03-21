package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.dao.WorkerDao;

import com.capgemini.domain.Worker;

@Repository
@Profile("mysql")
public class WorkerDaoImpl extends AbstractDao<Worker, Long> implements WorkerDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Worker findByNameAndSurname(String name, String surname) {
		MapSqlParameterSource nameAndSurnameParam = new MapSqlParameterSource("name", name);
		nameAndSurnameParam.addValue("surname", surname);
		List<Worker> workers = jdbcTemplate.query(
				"SELECT * from WORKER w where w.name = :name and w.surname = :surname", nameAndSurnameParam,
				new WorkerResultMapper());

		if (workers != null && workers.size() > 0) {
			return workers.get(0);
		}
		return null;
	}

	@Override
	public Worker searchByDepartmentName(String departmentName) {
		MapSqlParameterSource departmentNameParam = new MapSqlParameterSource("name", departmentName);
		List<Worker> workers = jdbcTemplate.query(
				"SELECT * from WORKER join DEPARTMENT d on worker.DEPARTMENT_ID = d.ID where d.name= :name",
				departmentNameParam, new WorkerResultMapper());
		if (workers != null && workers.size() > 0) {
			return workers.get(0);
		}
		return null;
	}

	@Override
	public List<Worker> findWorkerByDepartmetId(Long departmentId) {

		TypedQuery<Worker> query = entityManager
				.createQuery("SELECT w FROM Worker w JOIN w.department d  WHERE d.id = :departmentId", Worker.class);
		query.setParameter("departmentId", departmentId);
		return query.getResultList();

	}

	@Override
	public void saveWorker(Worker worker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanUp() {
		// TODO Auto-generated method stub
		
	}

}
