package com.practice.api.controller;

import com.practice.api.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student/get-one")
    public Student getOneStudent() {
        Student student = new Student("Tan", "Diep");
        return student;
    }

    @GetMapping("student/get-all")
    public List<Student> getAllStudents() {
        List<Student> listOfStudents = new ArrayList<>();

        Student firstStudent = new Student("Tan 1", "Diep 1");
        Student secondStudent = new Student("Tan 2", "Diep 2");
        Student thirdStudent = new Student("Tan 3", "Diep 2");

        listOfStudents.add(firstStudent);
        listOfStudents.add(secondStudent);
        listOfStudents.add(thirdStudent);

        return listOfStudents;
    }

    @GetMapping("/student/specific/{firstName}/{lastName}")
    public Student getSpecificStudent(@PathVariable("firstName") String firstName
                                     ,@PathVariable("lastName") String lastName) {
        Student student = new Student(firstName, lastName);
        return student;
    }

    // localhost:8080/student/query/?firstName=Tan&lastName=Diep
    @GetMapping("/student/query")
    public Student getStudentFromRequestParams(@RequestParam(name = "firstName") String firstName
                                              ,@RequestParam(name = "lastName") String lastName) {
        Student student = new Student(firstName, lastName);
        return student;
    }
}
