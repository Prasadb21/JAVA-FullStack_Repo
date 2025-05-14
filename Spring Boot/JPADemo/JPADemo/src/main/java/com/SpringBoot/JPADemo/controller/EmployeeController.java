package com.SpringBoot.JPADemo.controller;

import com.SpringBoot.JPADemo.entity.EmployeeEntity;
import com.SpringBoot.JPADemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<EmployeeEntity> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/saveEmployee")
    public EmployeeEntity saveEmployeeInDatabase(@RequestBody EmployeeEntity employeeEntity)
    {
        return employeeService.saveTheEmployeeInDatabase(employeeEntity);
    }

    @DeleteMapping("/{id}")
    public Optional<EmployeeEntity> deleteFromEmployeeTable(@PathVariable("id") int id)
    {
        return employeeService.deleteFromEmployeeTable(id);

    }




}
