package com.capgemini.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.Function;
import com.capgemini.domain.Project;
import com.capgemini.domain.ProjectHistory;
import com.capgemini.domain.Worker;

@RunWith(SpringRunner.class)
@SpringBootTest
// @Tansactional
public class ProjectHistoryServiceTest {

	@Autowired
	private ProjectHistoryService projectHistoryService;

	@Test
	// @Transactional
	public void shouldAddWorkerToProject() {

		// given
		LocalDate dateFrom = LocalDate.of(2013, 4, 15);
		LocalDate dateTo = LocalDate.of(2015, 5, 15);
		Function function = new Function();
		function.setName("TCD");
		
		ProjectHistory projectDetails = new ProjectHistory();
		projectDetails.setDateFrom(dateFrom);
		projectDetails.setDateTo(dateTo);
		projectDetails.setFunction(function);
		projectDetails.setLeader(true);
		
		Project project = new Project();
		project.setName("Zona");
		project.setProjectType("1");
		
		Worker worker = new Worker();
		worker.setName("Max");
		worker.setSurname("Adamczyk");
						
		// when
		ProjectHistory projectHistory = projectHistoryService.addWorkerToProject(worker, project);
		
		// then
		assertNotNull(projectHistory);
	}
	
	
	@Test
	public void shouldfindActiveWorkersInProjects(){
		//given
		Project project = new Project();
		project.setName("Zona");
		project.setProjectType("1");
		
		Worker worker = new Worker();
		worker.setName("Monika");
		worker.setSurname("Bielka");
		
		ProjectHistory projectDetails = new ProjectHistory();
		projectDetails.setWorker(worker);
		projectDetails.setProject(project);
		projectDetails.setLeader(true);
		//when
		List<Worker> findActiveWorkersInProject = projectHistoryService.findActiveWorkersInProject(project);
		//then
		assertEquals("Monika", findActiveWorkersInProject.get(0).getName());
	}
	
	@Test
	public void shouldRemoveWorkerFromFromProjectAndActualizeDateTo(){
		//given
		LocalDate dateFrom = LocalDate.of(2012, 5, 7);
		Function function = new Function();
		function.setName("FCL");
		
		ProjectHistory projectDetails = new ProjectHistory();
		projectDetails.setDateFrom(dateFrom);
		projectDetails.setFunction(function);
		projectDetails.setLeader(true);
		
		Project project = new Project();
		project.setName("NewAttidute");
		project.setProjectType("0");
		
		Worker worker = new Worker();
		worker.setName("John");
		worker.setSurname("Gorski");
		projectHistoryService.addWorkerToProject(worker, project);
		//when
		projectHistoryService.removeWorkerFromProject(worker, project);

		//then
		assertEquals(LocalDate.now(), projectDetails.getDateTo());
	}
	
	@Test
	public void shouldFindWorkersEmployeedInProjectLongerThanNMonths(){
		//given
		LocalDate dateFrom = LocalDate.of(2012, 3, 14);
		LocalDate dateTo = LocalDate.of(2014, 5, 7);
		Function function = new Function();
		function.setName("LCP");
		
		Project project = new Project();
		project.setName("Alfa");
		project.setProjectType("0");
		
		Worker worker = new Worker();
		worker.setName("John");
		worker.setSurname("Gorski");
		
		ProjectHistory projectDetails = new ProjectHistory();
		projectDetails.setDateFrom(dateFrom);
		projectDetails.setDateTo(dateTo);
		projectDetails.setFunction(function);
		projectDetails.setLeader(true);
		projectHistoryService.addWorkerToProject(worker, project);
		//when
		List<Worker> findWorkersInProjectByPeriod = projectHistoryService.findWorkersInProjectByPeriod(project, 7);
		//then
		assertNotNull(findWorkersInProjectByPeriod);
		assertEquals("John", findWorkersInProjectByPeriod.get(0).getName());
	}
}
