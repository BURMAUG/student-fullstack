package com.burmau.amigosstudent.repository;

import com.burmau.amigosstudent.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findByUsername(String username);
}
