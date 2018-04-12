package org.jtarun.redisservice.repository;

import org.jtarun.redisservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Qualifier(value = "redis")
public class RedisBackedStudentRepository implements StudentRepository{
    private RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "STUDENT";
    private HashOperations hashOperations;

    @Autowired
    RedisBackedStudentRepository(RedisTemplate<String, Object>  redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Student getStudent(int id) {
        return (Student)hashOperations.get(KEY, id);
    }

    @Override
    public List<Student> getAllStudents() {
         return (List<Student>)hashOperations.entries(KEY).values().stream().collect(Collectors.toList());
    }

    @Override
    public void addStudent(Student student) {
        hashOperations.put(KEY, student.getId(), student);
    }

    @Override
    public void deleteStudent(int id) {
        hashOperations.delete(KEY, id);
    }
}
