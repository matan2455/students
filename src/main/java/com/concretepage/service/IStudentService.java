package com.concretepage.service;

import com.concretepage.entity.Student;

import java.util.List;

public interface IStudentService {
    Student getStudentById(long studentId);

    List<Student> getAllStudents();

    boolean addStudent(Student student);

    void updateStudent(Student article, int id);

    void deleteStudent(int studentId);
}
