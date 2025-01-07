package com.spring.henallux.javaProjectB3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JavaProjectB3Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaProjectB3Application.class, args);
	}

}
