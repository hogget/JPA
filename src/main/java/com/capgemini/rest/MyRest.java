package com.capgemini.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.domain.Worker;
import com.capgemini.service.WorkerService;

public class MyRest {
	@Autowired
	private WorkerService workerService;

	@RequestMapping("/test")
	public Worker greeting() {
		Worker worker = new Worker();
		worker.setName("Majka");
		worker.setSurname("Majewska");
		worker.setPesel("98765412345");
		worker.setEmail("majka@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("72754904587");

		return workerService.saveWorker(worker);
	}

}
