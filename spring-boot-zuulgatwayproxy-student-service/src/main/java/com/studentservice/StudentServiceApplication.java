package com.studentservice;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.model.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class StudentServiceApplication {

	@RequestMapping(value = "/getStudentDetails/")
	public List getStudentDetails() {
//		Student st1=new Student(1, "hitesh", "24", "Delhi","Btech");
//		Student st2=new Student(2, "harshit", "20", "Pune","Btech");
//		Student st3=new Student(3, "preeti", "19", "Mathura","Mtech");
//		List<Student> list= Arrays.asList(st1,st2,st3);

		DatabaseSequence ds=new DatabaseSequence();
        return ds.getStudents();
		//return new Student(id, "1", "24", "Delhi","Btech");
	}

	@GetMapping(value = "/getStudentDetails/id/{id}")
	public Student getStudentDetails(@PathVariable(name = "id") int id) {
//		return new Student(id, "nishant", "24", "Delhi","Btech");
		System.out.println("NIshant------");
		DatabaseSequence ds=new DatabaseSequence();
		return ds.getStudent(id);
	}

	@GetMapping(value = "/getStudentDetails/name/{name}")
	public Student getStudentDetails(@PathVariable(name = "name") String name) {
		return new Student(1, name, "24", "Delhi","Btech");
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
}

