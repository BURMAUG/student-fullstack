package com.burmau.amigosstudent.controller;

import com.burmau.amigosstudent.mapper.StudentMapper;
import com.burmau.amigosstudent.model.Student;
import com.burmau.amigosstudent.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin(value = "http://localhost:3000/")
@Tag(name = "Student Controller", description = "This REST controller provides services to manages the Student web application.")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("index")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides all the student objects in the database snapshot", method = "GET")
    public Iterable<StudentMapper> allStudents(){
        Collection<StudentMapper> studentMappers = new ArrayList<>();
        for (Student student : studentService.studentList()) {
            studentMappers.add(
                    new StudentMapper(student.getStudent_id(), student.getName(), student.getEmail(), student.getMajor())
            );
        }
        return studentMappers;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Performs the duty of adding a new student to the database", method = "POST")
    public void addStudent(@Valid @RequestBody Student student){
        studentService.add(student);
    }

    @DeleteMapping("/{student_id}") 
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Performs the duty of deleting a student with the given id from the database", method = "DELETE")
    public void deleteStudent(@PathVariable int student_id){
        studentService.delete(student_id);
    }

    @PatchMapping("/{student_id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Performs the duty of updating a student object with the given id and object into the database", method = "PUT")
    public void edit(@RequestBody Student student, @PathVariable int student_id){
        studentService.update(student, student_id);
    }
}
