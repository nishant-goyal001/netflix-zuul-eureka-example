package com.service;

//import com.DAL.StudentServiceDAL;
import com.dal.StudentServiceDAL2;
import com.model.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    public void postStudentsService(Student student) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        ssd.insertStudents(student);
    }

    public List<Student> getStudentsService(int pageSize, int pageNum) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        return ssd.getStudents(pageSize,pageNum);
    }

    public List<Student> getStudentByIdService(String studentId) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        return ssd.getStudentById(studentId);
    }

    public List<Student> getStudentByNameService(String name) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        return ssd.getStudentByName(name);
    }

    public void deleteStudentService(int studentId) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        ssd.deleteStudent(studentId);
    }

    public void updateStudentService(Student student) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        ssd.updateStudent(student);
    }

    public List<Student> getStudentBetweenAgesService(int ageStart,int ageEnd) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        return ssd.getStudentBetweenAges(ageStart,ageEnd);
    }
}
