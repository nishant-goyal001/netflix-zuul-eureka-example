package com.studentservice;

public class Student {
        int id;
        String name;
        String age;
        String address;
        String course;

        public Student(int id,String name, String age, String address, String course) {
            super();
            this.id=id;
            this.name = name;
            this.age=age;
            this.address = address;
            this.course = course;
        }

        public int getId() {
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

    }
