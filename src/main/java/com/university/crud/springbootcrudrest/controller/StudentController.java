package com.university.crud.springbootcrudrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.crud.springbootcrudrest.model.Student;
import com.university.crud.springbootcrudrest.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") int id) {

		return service.getStudent(id);
	}

	@PostMapping("/")
	public void pseristStudent(Student obj) {

	}

	@PutMapping("/")
	public Student updateStudent(Student obj) {
		return obj;
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") int id) {

	}

}
