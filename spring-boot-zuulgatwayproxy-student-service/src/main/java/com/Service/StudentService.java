package com.Service;

import com.DAL.StudentServiceDAL;
import com.model.Student;

import java.util.List;

public class StudentService {

    public List<Student> getStudentsService() {
        StudentServiceDAL ssd=new StudentServiceDAL();
        return ssd.getStudents();
    }

    public Student getStudentService(int id) {
        StudentServiceDAL ssd=new StudentServiceDAL();
        return ssd.getStudent(id);
    }

    public Student getStudentService(String name) {
        StudentServiceDAL ssd=new StudentServiceDAL();
        return ssd.getStudent(name);
    }

    public void deleteStudentService(int id) {
        StudentServiceDAL ssd=new StudentServiceDAL();
        ssd.deleteStudent(id);
    }

    public void updateStudentService(Student student) {
        StudentServiceDAL ssd=new StudentServiceDAL();
        ssd.updateStudent(student);
    }

    public List<Student> getStudentBetweenAgesService(int ageStart,int ageEnd) {
        StudentServiceDAL ssd=new StudentServiceDAL();
        return ssd.getStudentBetweenAges(ageStart,ageEnd);
    }
}
