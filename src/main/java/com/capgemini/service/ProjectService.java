package com.capgemini.service;

import com.capgemini.domain.Project;

public interface ProjectService {
	 public Project save(Project project);
	 public void deleteProject (Long id);
	 public void updateProjectName (Project project);
	 public Project getOne(Project project);

}
