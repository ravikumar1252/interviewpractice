package com.person.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class JobApplication extends SpringBootServletInitializer {
	
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(JobApplication.class);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}

}
