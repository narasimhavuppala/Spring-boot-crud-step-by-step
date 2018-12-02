package com.university.crud.springbootcrudrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootCrudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudRestApplication.class, args);
	}
}
