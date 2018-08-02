package com.university.crud.springbootcrudrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.crud.springbootcrudrest.model.Student;
import com.university.crud.springbootcrudrest.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public Student getStudent(int id) {

		return repository.getOne(id);

	}

}
