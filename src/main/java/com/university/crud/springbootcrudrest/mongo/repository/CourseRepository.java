package com.university.crud.springbootcrudrest.mongo.repository;

import com.university.crud.springbootcrudrest.mongo.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
	Course findCourseByName(String name);
}
