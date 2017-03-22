package com.capgemini.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.ProjectHistoryDao;
import com.capgemini.dao.ProjectJpaRespository;
import com.capgemini.dao.WorkerJpaRepository;
import com.capgemini.domain.Function;
import com.capgemini.domain.Project;
import com.capgemini.domain.ProjectHistory;
import com.capgemini.domain.Worker;
import com.capgemini.service.ProjectHistoryService;


@Service
@Transactional
public class ProjectHistoryServiceImpl implements ProjectHistoryService {
	@Autowired
	ProjectHistoryDao projectHistory;
	@Autowired
	WorkerJpaRepository workerJpa;
	@Autowired
	ProjectJpaRespository projectJpa;

	@Override
	public List<Worker> findActiveWorkersInProject(Project project) {
		return projectHistory.findActiveWorkersInProject(project);
		}

	@Override
	public List<Worker> findWorkersInProjectByPeriod(Project project, int numberMonth) {
		return projectHistory.findWorkersInProjectFromLastNMonth(project, numberMonth);
		}

	@Override
	public ProjectHistory addWorkerToProject(Worker worker, Project project) {
		ProjectHistory findByWorkerAndProject = projectHistory.findByWorkerAndProject(worker, project);
		if (findByWorkerAndProject == null) {
			ProjectHistory ph = new ProjectHistory();
			LocalDate datefrom = LocalDate.of(2015, 8, 11);
			LocalDate dateTo = LocalDate.of(2015, 11, 11);
			ph.setDateFrom(datefrom);
			ph.setDateTo(dateTo);
			ph.setLeader(false);
			ph.setWorker(worker);
			ph.setProject(project);
			projectHistory.save(ph);
		}
		return findByWorkerAndProject;
	}

	@Override
	public ProjectHistory removeWorkerFromProject(Worker worker, Project project) {
		ProjectHistory findByWorkerAndProject = projectHistory.findByWorkerAndProject(worker, project);
		Function function = new Function();
		function.setName("INACTIVE");
		
		if (findByWorkerAndProject != null) {
			findByWorkerAndProject.setFunction(function);
			findByWorkerAndProject.setDateTo(LocalDate.now());
		}
		return null;
	}

}
