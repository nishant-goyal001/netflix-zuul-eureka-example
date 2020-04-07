package com.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
        @Id
        String studentId;
        String name;
        int age;
        String address;
        String course;
        List books;
}
