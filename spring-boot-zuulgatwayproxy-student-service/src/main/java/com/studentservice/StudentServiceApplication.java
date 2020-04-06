package com.studentservice;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.model.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class StudentServiceApplication {

	@RequestMapping(value = "/Students/")
	public List getStudentDetails() {
//		Student st1=new Student(1, "hitesh", "24", "Delhi","Btech");
//		Student st2=new Student(2, "harshit", "20", "Pune","Btech");
//		Student st3=new Student(3, "preeti", "19", "Mathura","Mtech");
//		List<Student> list= Arrays.asList(st1,st2,st3);

		DatabaseSequence ds=new DatabaseSequence();
        return ds.getStudents();
		//return new Student(id, "1", "24", "Delhi","Btech");
	}

	@GetMapping(value = "/Students/id/{id}")
	public Student getStudentDetails(@PathVariable(name = "id") int id) {
//		return new Student(id, "nishant", "24", "Delhi","Btech");
		DatabaseSequence ds=new DatabaseSequence();
		return ds.getStudent(id);
	}

	@GetMapping(value = "/Students/name/{name}")
	public Student getStudentDetails(@PathVariable(name = "name") String name) {
//		return new Student(1, name, "24", "Delhi","Btech");
		DatabaseSequence ds=new DatabaseSequence();
		return ds.getStudent(name);
	}

	@DeleteMapping (value = "/Students/id/{id}")
	public void deleteStudentDetails(@PathVariable(name = "id") int id) {
//		return new Student(id, "nishant", "24", "Delhi","Btech");
		DatabaseSequence ds=new DatabaseSequence();
		ds.deleteStudent(id);
	}

	@PutMapping (value = "/Students/")
	public void updateStudentDetails(@RequestBody Student student) {
		System.out.println("student in updateStudentDetails---"+student.toString());
		DatabaseSequence ds=new DatabaseSequence();
		ds.updateStudent(student);
	}

	@GetMapping(value = "/Students/id")
	public List getStudentDetails(@RequestParam int ageStart, @RequestParam int ageEnd) {
		DatabaseSequence ds=new DatabaseSequence();
		return ds.getStudentBetweenAges(ageStart,ageEnd);
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
}

