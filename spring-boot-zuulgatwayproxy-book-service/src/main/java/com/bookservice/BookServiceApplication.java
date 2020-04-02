package com.bookservice;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class BookServiceApplication {

	@RequestMapping(value = "/getBookDetails/{name}")
	public Book getBookDetails(@PathVariable(name = "name") String name) {
		return new Book(name, "Nishant");
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
}

