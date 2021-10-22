package com.university.crud.springbootcrudrest.mongo.service;

import com.university.crud.springbootcrudrest.mongo.model.Course;
import com.university.crud.springbootcrudrest.mongo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public void addCourse(Course Course) {
		courseRepository.save(Course);
	}

	public void updateCourse(Course Course) {
		courseRepository.save(Course);
	}

	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

	public Course getCourseByName(String name) {
		return courseRepository.findCourseByName(name);
	}
}
