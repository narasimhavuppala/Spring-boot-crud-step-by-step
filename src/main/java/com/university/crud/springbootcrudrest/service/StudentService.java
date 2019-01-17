package com.university.crud.springbootcrudrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.crud.springbootcrudrest.model.Student;
import com.university.crud.springbootcrudrest.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	Environment env;

	@Autowired
	private StudentRepository repository;

	public Student getStudent(int id) {

		return repository.getOne(id);

	}

	@Transactional
	public Student save(Student obj) throws Exception {
		if(obj.getId()==0) {
			throw new Exception("id is not valid");
		}

		return repository.save(obj);

	}

}
