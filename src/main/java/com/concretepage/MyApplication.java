package com.concretepage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {  
	public static void main(String[] args) {
		System.out.println("ok1");
		SpringApplication.run(MyApplication.class, args);
		System.out.println("ok2");
    }       
}            