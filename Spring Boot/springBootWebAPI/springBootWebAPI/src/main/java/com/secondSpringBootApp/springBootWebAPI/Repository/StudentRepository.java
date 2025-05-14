package com.secondSpringBootApp.springBootWebAPI.Repository;

import com.secondSpringBootApp.springBootWebAPI.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    List<Student> studentList = new ArrayList<>();

    public List<Student>getAllStudents()
    {

        return studentList;

    }


    public void saveStudent(Student student) {

        studentList.add(student);
        System.out.println("Student saved");

    }

    public void deleteStudentById(int id) {

        for(Student student:studentList)
        {
            if (student.getId() == id)
            {

                studentList.remove(student);
                System.out.println("Student removed successfully");
                break;

            }
        }

    }

    public Student updateStudentName(int id, String userName , String address) {

        Student studentPresent = studentList.get(id);
        studentPresent.setName(userName);
        studentPresent.setAdd(address);

        System.out.println("Student data updated");

        return studentPresent;

    }
}
