package com.university.crud.springbootcrudrest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	// web and Backends....Mobile apps...Use JSON Format
	public Student getStudent(@PathVariable("id") int id) {
		System.out.println(id);

		return service.getStudent(id);
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Student save(@Valid Student obj) throws Exception {
		System.out.println(obj.getId());
		return service.save(obj);

	}

	@PutMapping("/")
	public Student updateStudent(@Valid Student obj) {
		return obj;
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") int id) {

	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<String> getExceptions(Throwable t) {
		System.out.println(t.getMessage());
		System.out.println("Error Occureded");
		t.printStackTrace();
		return new ResponseEntity<String>("Error occured: "+ t.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
