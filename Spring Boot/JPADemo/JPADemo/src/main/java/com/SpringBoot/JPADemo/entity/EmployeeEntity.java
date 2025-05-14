package com.SpringBoot.JPADemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.lang.annotation.Target;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "EmployeeName")
    private String name;

    @Column(name = "EmployeeSalary")
    private double salary;

    @Column(name = "EmployeeDepartment")
    private String department;

}
