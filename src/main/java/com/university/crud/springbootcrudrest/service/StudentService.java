package com.university.crud.springbootcrudrest.service;

import com.university.crud.springbootcrudrest.messaging.StudentJmsSender;
import com.university.crud.springbootcrudrest.model.Student;
import com.university.crud.springbootcrudrest.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class StudentService {

    @Autowired
    Environment env;

    @Autowired
    StudentJmsSender jmsStudent;

    @Autowired
    private StudentRepository repository;

    @Transactional(readOnly = true)
    public Student getStudent(int id) {

        return repository.findById(id).get();

    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public Student save(Student obj) throws Exception {
        Student persitedObject = repository.save(obj);
        jmsStudent.pushStudentSave(persitedObject);
        return persitedObject;
    }

    @Transactional
    public Student update(int id, Student obj) throws Exception {
        obj.setId(id);
        Student persitedObject = repository.save(obj);
        jmsStudent.pushStudentSave(persitedObject);
        return persitedObject;
    }

    @Transactional
    public boolean delete(int id) throws Exception {
        repository.deleteById(id);
        jmsStudent.pushStringMessage("deleted Student with Id=" + 1);
        return true;
    }

    public List<Student> findByNameOrAge(String name, int age) {
        return repository.findByNameOrAge(name, age);
    }

}
