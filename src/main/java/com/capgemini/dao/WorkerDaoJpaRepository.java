package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.domain.Worker;

public interface WorkerDaoJpaRepository extends JpaRepository <Worker, Long>{
	
	public List<Worker> findByName (String name);
	public List<Worker> findBySurname (String surname);
	public List<Worker> findByEmail (String email);
	public List<Worker> findByPesel (String pesel);
	
}
