package com.model;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class Student {
        BigInteger id;
        @Id
        int studentId;
        String name;
        String age;
        String address;
        String course;

        public Student(BigInteger id,String name, String age, String address, String course) {
            super();
            this.id=id;
            this.name = name;
            this.age=age;
            this.address = address;
            this.course = course;
        }

        public Student() {

        }

        public BigInteger getId() {
            return id;
        }

        public String getName() {
        return name;
    }

        public String getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String getCourse() {
            return course;
        }


        public void setId(BigInteger id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
