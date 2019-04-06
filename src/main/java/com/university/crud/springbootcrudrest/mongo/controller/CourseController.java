package com.university.crud.springbootcrudrest.mongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.university.crud.springbootcrudrest.mongo.model.Course;
import com.university.crud.springbootcrudrest.mongo.service.CourseService;

@RestController("/course")
public class CourseController {
	
	private Logger logger=LoggerFactory.getLogger(CourseController.class.getName());
	@Autowired
    private CourseService courseService;

    @PostMapping
    public void addCourse(@RequestBody Course Course){
    	courseService.addCourse(Course);
    }

    @PutMapping
    public void updateCourse(@RequestBody Course Course){
    	logger.info(Course.toString());
    	courseService.addCourse(Course);
    }

    @GetMapping("/get/all")
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") String  CourseId){
    	courseService.deleteCourse(CourseId);
    }

    @GetMapping("/get/{name}")
    public Course getCourseById(@PathVariable("name") String  CourseName){
        return courseService.getCourseByName(CourseName);
}
}
