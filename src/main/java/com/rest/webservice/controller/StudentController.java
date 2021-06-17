package com.rest.webservice.controller;

import com.rest.webservice.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    //http://localhost:8080/api/v1/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        Student student = new Student(1, "Ahmed", "123");
        Student student2 = new Student(2, "Ali", "456");
        Student student3 = new Student(2, "Saad", "789");
        Student student4 = new Student(4, "Ramy", "852");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        return students;
    }
}
