package com.klu.RL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.klu.RL.model")  // Adjust the package path where your Admin entity is

public class RlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RlApplication.class, args);
		System.out.println("Welcome to Relief Link");
	}  

}
