package com.Service;

//import com.DAL.StudentServiceDAL;
import com.DAL.StudentServiceDAL2;
import com.model.Student;

import java.math.BigInteger;
import java.util.List;

public class StudentService {

    public List<Student> getStudentsService(int pageSize, int pageNum) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        return ssd.getStudents(pageSize,pageNum);
    }

    public List<Student> getStudentService(int studentId) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        return ssd.getStudent(studentId);
    }

    public List<Student> getStudentService(String name) {
        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        return ssd.getStudent(name);
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
