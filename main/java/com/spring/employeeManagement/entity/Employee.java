package com.spring.employeeManagement.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
//@XmlRootElement
public class Employee {

    @Id
    private Long id;
    private String name;
    private String department;
    private Double salary;
    private String email;

}
