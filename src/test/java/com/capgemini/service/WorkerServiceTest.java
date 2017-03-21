package com.capgemini.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.Department;
import com.capgemini.domain.Worker;

@RunWith(SpringRunner.class)
@SpringBootTest
// @Tansactional
public class WorkerServiceTest {


	@Autowired
	private WorkerService workerService;


	@Test
	// @Transactional
	public void testShouldSaveBook() {

		// given
		// String str = "2004-09-13";
		// DateTimeFormatter formatter =
		// DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// LocalDate date1 = LocalDate.parse(str, formatter);
		LocalDate date = LocalDate.of(2015, 8, 11);
		// LocalDate.parse ("2019-09-1")
		Worker worker = new Worker();
		worker.setName("Majka");
		worker.setSurname("Majewska");
		worker.setPesel("98765412345");
		worker.setBirthDate(date);
		worker.setEmail("majka@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("Production");
		worker.setDepartment(department);
		

		// when
		Worker saveWorker = workerService.saveWorker(worker);
		
		// then
		assertNotNull(saveWorker.getId());

	}

	@Test
	public void shouldGetWorkerByDepartmentId() {
		// given
		LocalDate date = LocalDate.of(2015, 8, 11);
	
		Worker worker = new Worker();
		worker.setName("Majka");
		worker.setSurname("Majewska");
		worker.setPesel("98765412345");
		worker.setBirthDate(date);
		worker.setEmail("majka@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("Production");
		worker.setDepartment(department);
		workerService.saveWorker(worker);
		
		// when
		List<Worker> workers = workerService.findWorkerByDepartmentId(1L);
		// then
		assertTrue(!workers.isEmpty());
	}
	

	@Test
	public void shouldFindWorkerByName() {
		// given
		LocalDate date = LocalDate.of(2015, 8, 11);
	
		Worker worker = new Worker();
		worker.setName("Majka");
		worker.setSurname("Majewska");
		worker.setPesel("98765412345");
		worker.setBirthDate(date);
		worker.setEmail("majka@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("Production");
		worker.setDepartment(department);
		workerService.saveWorker(worker);
		
		// when
		List<Worker> actualWorkers = workerService.findWorkerByName("Majka");
		// then
		assertTrue(!actualWorkers.isEmpty());
		assertEquals(worker.getName(), actualWorkers.get(0).getName());
	}
	
	@Test
	public void shouldUpdateWorker(){
		// given
		LocalDate date = LocalDate.of(2015, 8, 11);
	
		Worker worker = new Worker();
		worker.setName("Majka");
		worker.setSurname("Majewska");
		worker.setPesel("98765412345");
		worker.setBirthDate(date);
		worker.setEmail("majka@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("Production");
		worker.setDepartment(department);
		workerService.saveWorker(worker);
		worker.setName("Pawel");
		
		//when
		workerService.update(worker);
		//then
		Worker worker2 = workerService.getOne(worker.getId());
		String name = worker2.getName();
		assertEquals("Pawel", name);
	}
	
	@Test
	public void shouldDeleteWorker(){
		// given
		LocalDate date = LocalDate.of(2015, 8, 11);
	
		Worker worker = new Worker();
		worker.setName("Majka");
		worker.setSurname("Majewska");
		worker.setPesel("98765412345");
		worker.setBirthDate(date);
		worker.setEmail("majka@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("Production");
		worker.setDepartment(department);
		workerService.saveWorker(worker);
			
		//when
		workerService.deleteWorker(worker.getId());
		Worker worker3 = workerService.getOne(worker.getId());
		//then
		assertNull(worker3);
	}

	// @Test
	// @Transactional
	// public void testShouldGetOneBook(){
	// //given
	// Date date = new Date(2019, 04, 31);
	// WorkerEntity worker = new WorkerEntity(1L, "Adam", "Szymanowski",
	// "98765437267", date, "adam@onet.com",
	// "234565", "234556667");
	// //when
	// workerService.getOne(workerworker);
	//
	// //then
	//
	//
	// }

}
