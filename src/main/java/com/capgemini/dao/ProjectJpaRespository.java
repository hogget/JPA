package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.domain.Project;

public interface ProjectJpaRespository  extends JpaRepository <Project, Long>{
	
	
}
