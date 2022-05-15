package com.geek.staff.employee.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8796538784444962180L;

    private String empName;

    private String empCode;
}
