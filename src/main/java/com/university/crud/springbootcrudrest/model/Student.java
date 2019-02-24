package com.university.crud.springbootcrudrest.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Student {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	//@SequenceGenerator(sequenceName = "student_seq", allocationSize = 1, name = "student_seq")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	int id;

	@NotNull
	String name;

	@FutureOrPresent
	LocalDate dob = LocalDate.now();

	@Email
	String email;
	
	@Min(value=18,message="Age must be greater thyan 18 to get admission")
	int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
