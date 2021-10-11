package com.university.crud.springbootcrudrest.service;

import java.util.List;

import com.university.crud.springbootcrudrest.messaging.StudentJmsSender;
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
	StudentJmsSender jmsStudent;

	@Autowired
	private StudentRepository repository;

	@Transactional(readOnly = true)
	public Student getStudent(int id) {

		return repository.getOne(id);

	}

	@Transactional
	public Student save(Student obj) throws Exception {
		Student persitedObject = repository.save(obj);
		jmsStudent.pushStudentSave(persitedObject);
		return persitedObject;
	}

	@Transactional
	public Student update(int id,Student obj) throws Exception {
		obj.setId(id);
		Student persitedObject= repository.save(obj);
		jmsStudent.pushStudentSave(persitedObject);
		return persitedObject;
	}

	@Transactional
	public boolean delete(int id) throws Exception {
		repository.deleteById(id);
		jmsStudent.pushStringMessage("deleted Student with Id=" + 1);
		return true;
	}
	
	public List<Student> findByNameOrAge(String name,int age){
		return repository.findByNameOrAge(name, age);
	}

}
