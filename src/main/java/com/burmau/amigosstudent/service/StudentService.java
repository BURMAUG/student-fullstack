package com.burmau.amigosstudent.service;

import com.burmau.amigosstudent.model.Student;


public interface StudentService {
    Iterable<Student> studentList();

    void add(Student student);

    void delete(int student_id);

    void update(Student student, int student_id);
}
