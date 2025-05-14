package com.secondSpringBootApp.springBootWebAPI.controller;


import com.secondSpringBootApp.springBootWebAPI.Service.StudentService;
import com.secondSpringBootApp.springBootWebAPI.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;


    @GetMapping("/getAll")
    public List<Student> getAllStudents()
    {
        return service.getAllStudents();
    }

    @PostMapping("/saveStudent")
    public Student insertData(@RequestBody Student student)
    {
        System.out.println(student);
        service.saveStudent(student);

        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id)
    {

        System.out.println("Student id: " + id);

        service.deleteStudentBuId(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable int id, @RequestParam("name") String userName, @RequestParam("add") String address) {
        return service.updateStudentName(id, userName , address);
    }


}
