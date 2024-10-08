package com.burmau.amigosstudent.service.impl;

import com.burmau.amigosstudent.model.Student;
import com.burmau.amigosstudent.repository.StudentRepository;
import com.burmau.amigosstudent.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService, UserDetailsService {
    private final StudentRepository studentRepository;
    @Override
    public Iterable<Student> studentList() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int student_id) {
        studentRepository.deleteById(student_id);
    }

    @Override
    public void update(Student student, int student_id) {
        studentRepository.findById(student_id).ifPresent(student1 -> {
            student1.setName(student.getName());
            student1.setEmail(student.getEmail());
            student1.setMajor(student.getMajor());
            studentRepository.save(student1);
        });
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student studentOptional = studentRepository.findByUsername(username);
        return new User(username, studentOptional.getPassword(),
                true, true, true,true,
                AuthorityUtils.createAuthorityList(studentOptional.getRoles()));
    }
}
