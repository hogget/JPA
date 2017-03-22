package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
// @Transactional
public class ProjectServiceTest {

	@Autowired
	private ProjectService projectService;

	@Test
	// @Transactional
	public void shouldSaveProject() {

		// given
		Project project = new Project();
		project.setName("Builder");
		project.setProjectType("1");

		// when
		Project savedProject = projectService.save(project);

		// then
		assertNotNull(savedProject.getId());
	}

	@Test
	public void shouldUpdateProjectName() {
		// given

		Project project = new Project();
		project.setName("zebra");
		project.setModificationCounter(0);
		project.setProjectType("0");

		projectService.save(project);
		project.setName("AnotherName");

		// when
		projectService.updateProjectName(project);
		// then
		Project project2 = projectService.getOne(project);
		String name2 = project2.getName();
		assertEquals("AnotherName", name2);
	}

	@Test
	public void shouldUpdateProjectType() {
		// given

		Project project = new Project();
		project.setName("elephant");
		project.setModificationCounter(0);
		project.setProjectType("1");

		projectService.save(project);
		project.setProjectType("0");

		// when
		projectService.updateProjectName(project);
		// then
		Project project2 = projectService.getOne(project);
		String projectType2 = project2.getProjectType();
		assertEquals("0", projectType2);
	}

	@Test
	public void shouldDeleteProject() {
		// given
		Project project = new Project();
		project.setName("NewProject");
		project.setProjectType("1");
		projectService.save(project);

		// when
		projectService.deleteProject(project.getId());
		Project one = projectService.getOne(project);

		// then
		assertNull(one);
	}

}
