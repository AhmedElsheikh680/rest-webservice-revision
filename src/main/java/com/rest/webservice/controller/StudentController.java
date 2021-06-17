package com.rest.webservice.controller;

import com.rest.webservice.exception.StudentErrorResponse;
import com.rest.webservice.exception.StudentException;
import com.rest.webservice.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    List<Student> students = new ArrayList<>();
    @PostConstruct
    public void start(){
        Student student = new Student(1, "Ahmed", "123");
        Student student2 = new Student(2, "Ali", "456");
        Student student3 = new Student(3, "Saad", "789");
        Student student4 = new Student(4, "Ramy", "852");
        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);
    }

    //http://localhost:8080/api/v1/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return students;
    }

    //http://localhost:8080/api/v1/students/id
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        if(id <=0 || id > students.size()){
            throw new StudentException("Student Not Found Id: " + id);
        }
        return students.get(id -1);
    }

    //http://localhost:8080/api/v1/students?id=1
    @GetMapping("/student")
    public Student getStudentId(@RequestParam int id) {


        return students.get(id -1);
    }






}
