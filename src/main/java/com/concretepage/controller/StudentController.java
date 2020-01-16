package com.concretepage.controller;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import com.concretepage.entity.Student;
import com.concretepage.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("user")
@Component("com.concretepage.controller")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> list = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }

    @PostMapping("student")
    public ResponseEntity<Void> addStudent(@RequestBody Student student,UriComponentsBuilder builder) throws SQLSyntaxErrorException {
        boolean flag = studentService.addStudent(student);
        if (flag == false) {
            System.out.println("failed to add student");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        System.out.println("student was added");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/student/{id}").buildAndExpand(student.getStudentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("student/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") Integer id) {
        studentService.updateStudent(student,id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }


    @DeleteMapping("student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}