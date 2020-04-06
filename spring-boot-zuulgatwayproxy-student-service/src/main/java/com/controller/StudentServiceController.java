package com.controller;

//import com.DAL.StudentServiceDAL;
import com.Service.StudentService;
import com.model.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@SpringBootApplication
@EnableEurekaClient

@RequestMapping(value = "/student")
public class StudentServiceController {

	@GetMapping(value = "/page")
	public List getStudentDetailsByPageSize(@RequestParam int pageSize,@RequestParam int pageNum) {
		StudentService dss=new StudentService();
        return dss.getStudentsService(pageSize, pageNum);
	}

	@GetMapping(value = "/{id}")
	public List<Student> getStudentDetails(@PathVariable(name = "id") int studentId) {
		System.out.println("id----"+studentId);
		StudentService ss=new StudentService();
		return ss.getStudentService(studentId);
	}

	@GetMapping
	public List<Student> getStudentDetails(@RequestParam String name) {
		StudentService ss=new StudentService();
		return ss.getStudentService(name);
	}

	@DeleteMapping (value = "/{id}")
	public void deleteStudentDetails(@PathVariable(name = "id") int studentId) {
		StudentService ss=new StudentService();
		ss.deleteStudentService(studentId);
	}

	@PutMapping (value = "/")
	public void updateStudentDetails(@RequestBody Student student) {
		System.out.println("student in updateStudentDetails---"+student.toString());
		StudentService ss=new StudentService();
		ss.updateStudentService(student);
	}

	@GetMapping(value = "/age")    //Need to ask its mapping
	public List getStudentDetails(@RequestParam int ageStart, @RequestParam int ageEnd) {
		System.out.println("ageStart----"+ageStart);
		StudentService ss=new StudentService();
		return ss.getStudentBetweenAgesService(ageStart,ageEnd);
	}

}

