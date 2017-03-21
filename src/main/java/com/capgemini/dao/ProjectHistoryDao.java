package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Project;
import com.capgemini.domain.ProjectHistory;
import com.capgemini.domain.Worker;

public interface ProjectHistoryDao extends Dao<ProjectHistory, Long> {
	ProjectHistory findByWorkerAndProject(Worker worker, Project project);

	List<Worker> findActiveWorkersInProject(Project project);

	List <Worker> findWorkersInProjectFromLastNMonth(Project project, int numberMonth);
}