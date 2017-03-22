package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
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
	public void shouldFindWorkerByDepartmentId() {
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
	public void shouldFindWorkerByNameAndSurname() {
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
		Worker worker2 = workerService.findWorkerByNameAndSurname(worker.getName(), worker.getSurname());
		
		// then
		assertEquals("Majewska", worker2.getName());
	}
	

	@Test
	public void shouldFindWorkerByEmail() {
		// given
		LocalDate date = LocalDate.of(1997, 4, 18);
	
		Worker worker = new Worker();
		worker.setName("Jan");
		worker.setSurname("Kowalski");
		worker.setPesel("89768758765");
		worker.setBirthDate(date);
		worker.setEmail("janek@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("Accountancy");
		worker.setDepartment(department);
		workerService.saveWorker(worker);
		
		// when
		List<Worker> actualWorkers = workerService.findWorkerByEmail("janek@onet.com");
		// then
		assertTrue(!actualWorkers.isEmpty());
		assertEquals(worker.getEmail(), actualWorkers.get(0).getEmail());
	}
	
	@Test
	public void shouldFindWorkerBySurname() {
		// given
		LocalDate date = LocalDate.of(1992, 1, 12);
	
		Worker worker = new Worker();
		worker.setName("Otylia");
		worker.setSurname("Adamska");
		worker.setPesel("12345678459");
		worker.setBirthDate(date);
		worker.setEmail("otylia@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("HR");
		worker.setDepartment(department);
		workerService.saveWorker(worker);
		
		// when
		List<Worker> actualWorkers = workerService.findWorkerBySurname("Adamska");
		// then
		assertTrue(!actualWorkers.isEmpty());
		assertEquals(worker.getSurname(), actualWorkers.get(0).getSurname());
	}
	@Test
	public void shouldFindWorkerByPesel() {
		// given
		LocalDate date = LocalDate.of(1991, 3, 14);
	
		Worker worker = new Worker();
		worker.setName("Otylia");
		worker.setSurname("Adamska");
		worker.setPesel("91031456789");
		worker.setBirthDate(date);
		worker.setEmail("otylia@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");
		Department department = new Department();
		department.setName("HR");
		worker.setDepartment(department);
		workerService.saveWorker(worker);
		
		// when
		List<Worker> actualWorkers = workerService.findWorkerByPesel("91031456789");
		// then
		assertTrue(!actualWorkers.isEmpty());
		assertEquals(worker.getPesel(), actualWorkers.get(0).getPesel());
	}
	@Test
	public void shouldUpdateWorkerName(){
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
	public void shouldUpdateWorkerPesel(){
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
		worker.setPesel("98765467456");
		
		//when
		workerService.update(worker);
		//then
		Worker worker2 = workerService.getOne(worker.getId());
		String pesel = worker2.getPesel();
		assertEquals("98765467456", pesel);
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

	@Test(expected = ObjectOptimisticLockingFailureException.class)
	public void shouldNotUpdateWorkerDetailsIdVersionHasChanged(){
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
		worker.setPesel("23456765487");
		//when
		Worker worker2 = workerService.getOne(worker.getId());
		worker2.setName("Zosia");
		workerService.update(worker);
		workerService.update(worker2);
						
	}

}
