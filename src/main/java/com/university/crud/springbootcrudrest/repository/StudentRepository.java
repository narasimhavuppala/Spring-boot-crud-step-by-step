package com.university.crud.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.crud.springbootcrudrest.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//Code Generation Technique: DSL 
}
