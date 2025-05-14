package com.SpringBoot.JPADemo.service;


import com.SpringBoot.JPADemo.entity.EmployeeEntity;
import com.SpringBoot.JPADemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployee()
    {
        System.out.println(employeeRepository.findAll());
        return employeeRepository.findAll();
    }

    public EmployeeEntity saveTheEmployeeInDatabase(EmployeeEntity employeeEntity)
    {
        employeeRepository.save(employeeEntity);
        return employeeEntity;
    }


    public Optional<EmployeeEntity> deleteFromEmployeeTable(int id) {

        Optional<EmployeeEntity> employeeDeleted = employeeRepository.findById(id);
        if(employeeRepository.existsById(id))
        {
            employeeRepository.deleteById(id);
        }
        else
        {
            System.out.println("Employee not present in database !!");
        }

        return employeeDeleted;

    }
}
