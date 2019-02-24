package com.university.crud.springbootcrudrest.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.university.crud.springbootcrudrest.model.Student;
import com.university.crud.springbootcrudrest.mongo.model.Course;

public interface CourseRepository extends MongoRepository<Course, String> {
	Course findCourseByName(String name);
}
