package com.SpringBoot.JPADemo.repository;

import com.SpringBoot.JPADemo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Integer> {



}
