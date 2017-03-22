package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.WorkerDao;
import com.capgemini.dao.WorkerJpaRepository;
//import com.capgemini.dao.WorkerDaoJpaRepository;
import com.capgemini.domain.Worker;
import com.capgemini.service.WorkerService;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

	@Autowired(required = true)
	private WorkerDao workerDao;
	@Autowired(required = true)
	private WorkerJpaRepository workerJpa;

	public Worker saveWorker(Worker worker) {
		worker = workerDao.save(worker);
		return worker;
	}

	@Override
	public Worker getOne(Long id) {
		return workerDao.getOne(id);
	}

	@Override
	public List<Worker> findWorkerByName(String name) {
		return workerJpa.findByName(name);
	}

	@Override
	public List<Worker> findWorkerBySurname(String surname) {
		return workerJpa.findBySurname(surname);
	}

	@Override
	public List<Worker> findWorkerByEmail(String email) {
		return workerJpa.findByEmail(email);
	}

	@Override
	public List<Worker> findWorkerByPesel(String pesel) {
		return workerJpa.findByPesel(pesel);
	}

	@Override
	public void deleteWorker(Long id) {
		workerJpa.delete(id);
	}

	@Override
	public Worker findWorkerById(Long id) {
		return workerJpa.findOne(id);
	}

	@Override
	public List<Worker> findWorkerByDepartmentId(Long departmentId) {
		return workerDao.findWorkerByDepartmetId(departmentId);

	}

	@Override
	public void update(Worker worker) {
		workerDao.update(worker);
	}

	@Override
	public Worker findWorkerByNameAndSurname(String name, String surname) {
		return workerDao.findByNameAndSurname(name, surname);
	}
}
