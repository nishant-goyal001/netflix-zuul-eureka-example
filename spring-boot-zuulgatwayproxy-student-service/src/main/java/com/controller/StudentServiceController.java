package com.controller;

import com.DAL.StudentServiceDAL;
import com.Service.StudentService;
import com.model.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
@EnableEurekaClient

@RequestMapping(value = "/student")
public class StudentServiceController {

	@RequestMapping(value = "/")
	public List getStudentDetails() {
		StudentService dss=new StudentService();
        return dss.getStudentsService();
	}

	@GetMapping(value = "/{id}")
	public Student getStudentDetails(@PathVariable(name = "id") int id) {
		StudentService ss=new StudentService();
		return ss.getStudentService(id);
	}

	@GetMapping
	public Student getStudentDetails(@RequestParam String name) {
		StudentService ss=new StudentService();
		return ss.getStudentService(name);
	}

	@DeleteMapping (value = "/{id}")
	public void deleteStudentDetails(@PathVariable(name = "id") int id) {
		StudentService ss=new StudentService();
		ss.deleteStudentService(id);
	}

	@PutMapping (value = "/")
	public void updateStudentDetails(@RequestBody Student student) {
		System.out.println("student in updateStudentDetails---"+student.toString());
		StudentService ss=new StudentService();
		ss.updateStudentService(student);
	}

	@GetMapping(value = "/id")
	public List getStudentDetails(@RequestParam int ageStart, @RequestParam int ageEnd) {
		StudentService ss=new StudentService();
		return ss.getStudentBetweenAgesService(ageStart,ageEnd);
	}

}

