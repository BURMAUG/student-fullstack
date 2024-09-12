package com.burmau.amigosstudent;

import com.burmau.amigosstudent.model.Student;
import com.burmau.amigosstudent.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@AllArgsConstructor
public class AmigosstudentApplication {
    private StudentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AmigosstudentApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            repository.save(new Student(1, "Burmnau", "b@student.com", "physics", "admin", new BCryptPasswordEncoder().encode("admin"), "admin"));
            repository.save(new Student(2, "Shila", "s@student.com", "Computer Science", "user", new BCryptPasswordEncoder().encode("shila"), "read"));
        };
    }
}
