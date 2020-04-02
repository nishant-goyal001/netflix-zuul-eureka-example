package com.studentservice;

public class Student {
        String name;
        String rollNo;
        String address;
        String course;

        public Student(String name, String rollNo, String address, String course) {
            super();
            this.name = name;
            this.rollNo=rollNo;
            this.address = address;
            this.course = course;
        }

        public String getName() {
            return name;
        }

        public String getRollNo() {
            return rollNo;
        }

        public String getAddress() {
            return address;
        }

        public String getCourse() {
            return course;
        }

    }
