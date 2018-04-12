package org.jtarun.redisservice.repository;

import org.jtarun.redisservice.model.Student;

import java.util.List;

public interface StudentRepository {
    Student getStudent(int id);
    List<Student> getAllStudents();
    void addStudent(Student student);
    void deleteStudent(int id);
}
