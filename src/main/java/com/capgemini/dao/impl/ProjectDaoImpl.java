package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.ProjectDao;
import com.capgemini.domain.Project;

@Repository
public class ProjectDaoImpl  extends AbstractDao<Project, Long> implements ProjectDao{


}
