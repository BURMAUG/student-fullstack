package com.burmau.amigosstudent.security;

import com.burmau.amigosstudent.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class StudentSecurity {

    private final UserDetailsService userDetailsService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        return http.authorizeHttpRequests(authorizeRequests ->{
            authorizeRequests.requestMatchers("/api/v1/index").permitAll();
            authorizeRequests.requestMatchers("http://localhost:8080/v3/api-doc").permitAll();
            authorizeRequests.requestMatchers("/login").permitAll();
            authorizeRequests.requestMatchers("/signup").permitAll();
            authorizeRequests.anyRequest().authenticated();
        }).formLogin(Customizer.withDefaults())
                .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
