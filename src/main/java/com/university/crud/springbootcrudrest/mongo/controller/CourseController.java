package com.university.crud.springbootcrudrest.mongo.controller;

import java.util.List;

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

@RestController
public class CourseController {
	@Autowired
    private CourseService courseService;

    @PostMapping("/Course/add")
    public void addCourse(@RequestBody Course Course){
    	courseService.addCourse(Course);
    }

    @PutMapping("/Course/add")
    public void updateCourse(@RequestBody Course Course){
    	courseService.addCourse(Course);
    }

    @GetMapping("/Course/get/all")
    public List<Course> addCourse(){
        return courseService.getAllCourse();
    }

    @DeleteMapping("/Course/delete/{id}")
    public void deleteCourse(@PathVariable("id") String  CourseId){
    	courseService.deleteCourse(CourseId);
    }

    @GetMapping("/Course/get/{name}")
    public Course getCourseById(@PathVariable("name") String  CourseName){
        return courseService.getCourseByName(CourseName);
}
}
