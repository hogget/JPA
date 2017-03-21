package com.capgemini;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.service.ServiceTestSuite;
import com.capgemini.service.impl.WorkerServiceImpl;

@RunWith(Suite.class)
@SuiteClasses({ ServiceTestSuite.class })
public class AllTests {

	@Autowired
	private WorkerServiceImpl workerService;

	@Test
	public void testShouldSaveBook() {

		// given

		
		// when
	
		// then
	

	}
}
