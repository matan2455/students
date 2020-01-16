package com.concretepage.client;

import java.net.URI;

import com.concretepage.entity.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientUtil {
    public void getStudentByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/student/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Student> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student.class, 1);
        Student student = responseEntity.getBody();
        System.out.println("Id:"+student.getStudentId()+", Title:"+student.getFirstName()
                 +", Category:"+student.getLastName() + ", phone Number" + student.getPhoneNumber());
    }
	public void getAllStudentsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/articles";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Student[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student[].class);
        Student[] students = responseEntity.getBody();
        for(Student student : students) {
            System.out.println("Id:"+student.getStudentId()+", Title:"+student.getFirstName()
                    +", Category:"+student.getLastName() + ", phone Number" + student.getPhoneNumber());
        }
    }
    public void addStudentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article";
        Student objStudent = new Student();
        objStudent.setFirstName("Spring REST Security using Hibernate");
        objStudent.setLastName("Spring");
        objStudent.setPhoneNumber("0537257325");
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(objStudent, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateStudentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article";
        Student objStudent = new Student();
        objStudent.setStudentId(1);
        objStudent.setFirstName("Update:Java Concurrency");
        objStudent.setLastName("Java");
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(objStudent, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteStudentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article/{id}";
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getStudentByIdDemo();
    	//util.addStudentDemo();
    	//util.updateStudentDemo();
    	//util.deleteStudentDemo();
    	util.getAllStudentsDemo();
    }    
}
