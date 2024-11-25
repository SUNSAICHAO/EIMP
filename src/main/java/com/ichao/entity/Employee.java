package com.ichao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String sex;
    private String age;
    private String education;
    private String department;
    private String date;
    private String duty;
    private String wage;
}
