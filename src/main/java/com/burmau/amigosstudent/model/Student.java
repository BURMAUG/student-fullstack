package com.burmau.amigosstudent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode
@Getter @Setter
@Table(name = "students")
public class Student{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int student_id;
        @NotBlank
        private String name;
        @Email @NotBlank
        private String email;
        private String major;
        @Column(unique = true, nullable = false, name = "username")
        private String username;
        @Column(unique = true, nullable = false, name = "password")
        private String password;
        @Column(unique = true, nullable = false, name = "roles")
        private String roles;
}
