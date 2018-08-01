package com.university.crud.springbootcrudrest.model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Student {
	int id;
	String name;
	LocalDate dob;

}
