package com.concretepage.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name="students")
public class Student implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private long studentId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Size(min = 8, max = 11)
    @Column(name="phoneNumber")
    private String phoneNumber;

    //Setters
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Getters
    public long getStudentId() {
        return studentId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getPhoneNumber() { return phoneNumber; }
}


