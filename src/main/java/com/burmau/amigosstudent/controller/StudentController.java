package com.burmau.amigosstudent.controller;

import com.burmau.amigosstudent.model.Student;
import com.burmau.amigosstudent.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin(value = "http://localhost:3000/")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Student> allStudents(){
        return studentService.studentList();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.add(student);
    }
    @DeleteMapping("/{student_id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable int student_id){
        studentService.delete(student_id);
    }
    @PutMapping("/{student_id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void edit(@RequestBody Student student, @PathVariable int student_id){
        studentService.update(student, student_id);
    }
}
