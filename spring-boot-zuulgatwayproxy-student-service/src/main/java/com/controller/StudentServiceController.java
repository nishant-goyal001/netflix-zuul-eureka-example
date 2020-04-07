package com.controller;

//import com.DAL.StudentServiceDAL;

import com.model.Student;
import com.sal.StudentServiceSAL;
import com.service.StudentService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
@EnableEurekaClient

@RequestMapping(value = "/student")
public class StudentServiceController {

	@PostMapping(value = "/")
	public void postBookDetails(@RequestBody Student student) {
		StudentService ss=new StudentService();
		ss.postStudentsService(student);
	}

	@GetMapping(value = "/page")
	public List getStudentDetailsByPageSize(@RequestParam int pageSize,@RequestParam int pageNum) {
		StudentService dss=new StudentService();
        return dss.getStudentsService(pageSize, pageNum);
	}

	@GetMapping(value = "/{id}")
	public List<Student> getStudentDetailsById(@PathVariable(name = "id") String studentId) {
		StudentService ss=new StudentService();
		return ss.getStudentByIdService(studentId);
	}

	@GetMapping
	public List<Student> getStudentDetailsByName(@RequestParam String name) {
		StudentService ss=new StudentService();
		return ss.getStudentByNameService(name);
	}

	@DeleteMapping (value = "/{id}")
	public void deleteStudentDetails(@PathVariable(name = "id") int studentId) {
		StudentService ss=new StudentService();
		ss.deleteStudentService(studentId);
	}

	@PutMapping (value = "/")
	public void updateStudentDetails(@RequestBody Student student) {
		StudentService ss=new StudentService();
		ss.updateStudentService(student);
	}

	@GetMapping(value = "/age")    //Need to ask its mapping
	public List getStudentDetails(@RequestParam int ageStart, @RequestParam int ageEnd) {
		StudentService ss=new StudentService();
		return ss.getStudentBetweenAgesService(ageStart,ageEnd);
	}

	@GetMapping(value="/{id}/book")
	public List<HttpEntity<String>> getStudentBooksDetails(@PathVariable(name = "id") String studentId) {
		StudentServiceSAL ss=new StudentServiceSAL();
		return ss.getStudentBooksService(studentId);
	}

}

