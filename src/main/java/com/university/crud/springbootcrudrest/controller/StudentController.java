package com.university.crud.springbootcrudrest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.crud.springbootcrudrest.model.Student;

@RestController
public class StudentController {

	@GetMapping("/:id")
	public Student getStudent(@PathVariable("id") String id) {

		return new Student();
	}

	@PostMapping("/")
	public void pseristStudent(Student obj) {

	}

	@PutMapping("/")
	public Student updateStudent(Student obj) {
		return obj;
	}

	@DeleteMapping("/:id")
	public void deleteStudent(@PathVariable("id") int id) {

	}

}
