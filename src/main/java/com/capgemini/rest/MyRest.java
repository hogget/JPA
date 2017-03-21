package com.capgemini.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.domain.Department;
import com.capgemini.domain.Worker;
import com.capgemini.service.WorkerService;

@Controller
public class MyRest {
	@Autowired
	private WorkerService workerService;

	@RequestMapping("/test")
	@ResponseBody
	public Worker greeting() {
		Worker worker = new Worker();
		worker.setName("Majka");
		worker.setSurname("Majewska");
		worker.setPesel("98765412345");
		worker.setEmail("majka@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("Production");
		worker.setDepartment(department);
		return workerService.saveWorker(worker);
	}

}
