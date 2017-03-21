package com.capgemini.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.Department;
import com.capgemini.domain.Worker;


@RunWith(SpringRunner.class)
@SpringBootTest
//@Tansactional
public class WorkerServiceTest {

	@Autowired
	private WorkerService workerService;
	

	@Test
	//@Transactional
	public void testShouldSaveBook() {

		// given
//		String str = "2004-09-13";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date1 = LocalDate.parse(str, formatter);
		LocalDate date = LocalDate.of(2015, 8, 11);
		//LocalDate.parse ("2019-09-1")
		Worker worker = new Worker();
		worker.setName("Majka");
		worker.setSurname("Majewska");
		worker.setPesel("98765412345");
		worker.setBirthDate(date);
		worker.setEmail("majka@onet.com");
		worker.setMobilePhoneNumber("27364685");
		worker.setHomePhoneNumber("7275");


		// when
		Worker saveWorker = workerService.saveWorker(worker);
		
		// then
		assertNotNull(saveWorker.getId());

	}
//	
//	@Test 
//	public void shouldGetWorkerByDepartmentId(){
//		//given
//		Department dep = new Department();
//		dep.setId(1L);
//		
//		//when
//		
//		//then
//	}
	
//	@Test
//	@Transactional
//	public void testShouldGetOneBook(){
//		//given
//		Date date = new Date(2019, 04, 31);
//		WorkerEntity worker = new WorkerEntity(1L, "Adam", "Szymanowski", "98765437267", date, "adam@onet.com",
//				"234565", "234556667");
//		//when
//		workerService.getOne(workerworker);
//		
//		//then 
//		
//		
//	}
	
}
