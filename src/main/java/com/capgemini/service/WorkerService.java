package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.Worker;

public interface WorkerService {
	
	 public Worker saveWorker(Worker worker);
	 public Worker getOne(Long id);
	 public List <Worker> findWorkerByName (String name);
	 public List <Worker> findWorkerBySurname (String surname);
	 public List <Worker> findWorkerByEmail (String email);
	 public List <Worker> findWorkerByPesel (String pesel);
	 public Worker findWorkerById (Long id);
	 public void deleteWorker (Long id);
	 public List<Worker> findWorkerByDepartmentId(Long departmentId) ;
	 public void update(Worker worker);
	 public Worker findWorkerByNameAndSurname (String name, String surname);
}
