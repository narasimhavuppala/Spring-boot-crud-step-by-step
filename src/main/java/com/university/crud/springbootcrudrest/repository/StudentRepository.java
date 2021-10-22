package com.university.crud.springbootcrudrest.repository;

import com.university.crud.springbootcrudrest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Code Generation Technique: DSL
	//DSL: Domain Specific Language
	public void deleteById(int id);
	
	public List<Student> findByNameOrAge(String name,int age);
}
