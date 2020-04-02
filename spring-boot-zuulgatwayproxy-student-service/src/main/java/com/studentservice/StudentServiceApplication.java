package com.studentservice;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class StudentServiceApplication {

	@RequestMapping(value = "/getStudentDetails/{name}")
	public Student getStudentDetails(@PathVariable(name = "name") String name) {
		return new Student(name, "1", "Noida", "B-Tech");
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
}

