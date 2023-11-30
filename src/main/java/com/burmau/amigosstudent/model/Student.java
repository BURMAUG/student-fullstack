package com.burmau.amigosstudent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode
@Getter @Setter
public class Student{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int student_id;
        @NotBlank
        private String name;
        @Email @NotBlank
        private String email;
        private String major;
}
