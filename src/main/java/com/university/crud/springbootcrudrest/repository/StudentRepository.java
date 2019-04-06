package com.university.crud.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.crud.springbootcrudrest.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//Code Generation Technique: DSL 
	//DSL: Domain Specific Language
	public void deleteById(int id);
	
	public List<Student> findByNameOrAge(String name,int age);
}
