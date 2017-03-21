package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.capgemini.rest.MyRest;

//import com.capgemini.rest.MyRest;

@SpringBootApplication
public class StarterKitJpaStarterApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(StarterKitJpaStarterApplication.class, args);
//		MyRest bean = run.getBean(MyRest.class);
//		bean.greeting();
//		System.out.println("Book saved");
//		MyRest rest = new MyRest();
//		rest.greeting();
	}
}
