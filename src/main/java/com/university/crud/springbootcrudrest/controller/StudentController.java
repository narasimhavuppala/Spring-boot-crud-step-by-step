package com.university.crud.springbootcrudrest.controller;

import com.university.crud.springbootcrudrest.model.Student;
import com.university.crud.springbootcrudrest.service.StudentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Tag(name = "student service  for API", description = "controller for the service ")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " Successful"),
            @ApiResponse(responseCode = "401", description = "UnAuthorized")
    })
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


}
