package com.secondSpringBootApp.springBootWebAPI.Service;

import com.secondSpringBootApp.springBootWebAPI.Repository.StudentRepository;
import com.secondSpringBootApp.springBootWebAPI.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents()
    {
        return studentRepository.getAllStudents();
    }

    public void saveStudent(Student student) {

        studentRepository.saveStudent(student);
    }

    public void deleteStudentBuId(int id) {

        studentRepository.deleteStudentById(id);

    }

    public Student updateStudentName(int id, String userName , String address) {

        return studentRepository.updateStudentName(id,userName , address);

    }
}
