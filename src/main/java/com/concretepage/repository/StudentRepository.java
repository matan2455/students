package com.concretepage.repository;

import com.concretepage.entity.Student;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findDistinctByLastName(String lastName);
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
}
