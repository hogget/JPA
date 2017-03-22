package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.ProjectDao;
import com.capgemini.dao.ProjectJpaRespository;
import com.capgemini.domain.Project;
import com.capgemini.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
	@Autowired 
	private ProjectJpaRespository projectJpa;
	@Autowired
	private ProjectDao projectDao;

	@Override
	public Project save(Project project) {
		return projectJpa.save(project);
		}

	@Override
	public void deleteProject(Long id) {
		Project one = projectJpa.getOne(id);
		projectJpa.delete(one);		
	}

	@Override
	public void updateProjectName(Project project) {
		projectDao.update(project);		
	}

	@Override
	public Project getOne(Project project) {
		return projectJpa.getOne(project.getId());
	}
}
