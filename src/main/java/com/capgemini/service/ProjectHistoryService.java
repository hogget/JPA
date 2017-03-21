package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.Project;
import com.capgemini.domain.ProjectHistory;
import com.capgemini.domain.Worker;

public interface ProjectHistoryService {
	ProjectHistory addWorkerToProject (Worker worker, Project project);
	ProjectHistory removeWorkerFromProject (Worker worker, Project project);
	//ProjectHistory updateProjectHistory (Worker worker, ProjectHistory projectHistory);
	List<Worker> findActiveWorkersInProject (Project project);
	List<Worker> findWorkersInProjectByPeriod (Project project, int numberMonth);
	
}
