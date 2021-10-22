package com.university.crud.springbootcrudrest.mongo.controller;

import com.university.crud.springbootcrudrest.mongo.model.Course;
import com.university.crud.springbootcrudrest.mongo.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
