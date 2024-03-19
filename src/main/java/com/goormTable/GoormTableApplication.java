package com.goormTable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GoormTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoormTableApplication.class, args);
	}

}
