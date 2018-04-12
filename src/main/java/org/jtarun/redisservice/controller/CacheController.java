package org.jtarun.redisservice.controller;

import org.jtarun.redisservice.model.Student;
import org.jtarun.redisservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CacheController {
    @Autowired
    @Qualifier(value = "redis")
    private StudentRepository studentRepository;

    @RequestMapping(value = "/student/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable(value = "id") int id) {
        Student student = studentRepository.getStudent(id);
        return student;
    }

    @RequestMapping(value="/student" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        return studentRepository.getAllStudents();
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addStudent(@RequestBody Student student) {
        studentRepository.addStudent(student);
    }

    @RequestMapping(value="/student/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int id )  {
        studentRepository.deleteStudent(id);
    }
}