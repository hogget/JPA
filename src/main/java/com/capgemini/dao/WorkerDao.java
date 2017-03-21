package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Worker;

public interface WorkerDao extends Dao<Worker, Long> {
	public void saveWorker (Worker worker);
	public void cleanUp();
	
	public List<Worker> findWorkerByDepartmetId (Long departmentId);
	public Worker save(Worker entity);
	public Worker findByNameAndSurname (String name, String surname);
	public Worker searchByDepartmentName (String departmentName);
}

//obsluz na poziomie serwisu wyjatki ze usuwasz z=cos nie istniejace lub dodajesz to co istnieje
//