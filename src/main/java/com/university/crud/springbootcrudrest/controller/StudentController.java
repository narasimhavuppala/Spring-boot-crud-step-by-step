package com.university.crud.springbootcrudrest.controller;

import com.university.crud.springbootcrudrest.model.Student;
import com.university.crud.springbootcrudrest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // web and Backends....Mobile apps...Use JSON Format
    public Student getStudent(@PathVariable("id") int id) {
        System.out.println(id);

        return service.getStudent(id);
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student save(@Valid @RequestBody Student obj) throws Exception {
        System.out.println(obj.getId());
        return service.save(obj);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@Valid Student obj, @PathVariable("id") int studentId) throws Exception {
        return service.update(studentId, obj);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable("id") int id) throws Exception {
        return service.delete(id);
    }

    @GetMapping("/{name}/{age}")
    public List<Student> findByNameOrAge(@PathVariable("name") String studentName, @PathVariable("age") int studentAge) throws Exception {
        return service.findByNameOrAge(studentName, studentAge);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> getExceptions(Throwable t) {
        System.out.println(t.getMessage());
        System.out.println("Error Occureded");
        t.printStackTrace();
        return new ResponseEntity<String>("Error occured: " + t.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
