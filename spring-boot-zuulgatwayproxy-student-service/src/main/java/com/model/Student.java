package com.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
        BigInteger id;
        @Id
        int studentId;
        String name;
        int age;
        String address;
        String course;
}
