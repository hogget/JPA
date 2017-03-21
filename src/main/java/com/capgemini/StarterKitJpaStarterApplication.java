package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.rest.MyRest;

//import com.capgemini.rest.MyRest;

@SpringBootApplication
public class StarterKitJpaStarterApplication {

	public static void main(String[] args) {

		SpringApplication.run(StarterKitJpaStarterApplication.class, args);
		System.out.println("Book saved");
		MyRest rest = new MyRest();
		rest.greeting();
	}
}
