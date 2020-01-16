package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.concretepage.entity.Student;
import com.concretepage.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService implements IStudentService {
    @Autowired
    private StudentRepository StudentRepository;
    @Override
    public Student getStudentById(long studentId) {
        Student obj = StudentRepository.findById(studentId).get();
        return obj;
    }
    @Override
    public List<Student> getAllStudents(){
        List<Student> list = new ArrayList<>();
        StudentRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public synchronized boolean addStudent(Student student){
        List<Student> list = StudentRepository.findByFirstNameAndLastName(student.getFirstName(), student.getLastName());
        if (list.size() > 0) {
            return false;
        } else {
            StudentRepository.save(student);
            return true;
        }
    }

    @Override
    public void updateStudent(Student student, int id) {
        Optional<Student> optionalStudentToUpdate = StudentRepository.findById((long)id);
        if(optionalStudentToUpdate.isPresent()){
            //we dont need to set a new student object - save method also works as 'update' method
            //we set the new student id according to the id received from the class path
            student.setStudentId((long)id);
            StudentRepository.save(student);
        }else{
            System.out.println("no such element");
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        StudentRepository.delete(getStudentById(studentId));
    }
}
