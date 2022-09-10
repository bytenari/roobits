package com.mainframe.mainframe.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.crsf().disable(); // postman 연결 시 disable 해야 함
        http.headers().frameOptions().disable(); // h2 연결

        http.authorizeRequests()
                .antMatchers("/guest/**").authenticated()
                .antMatchers("/host/**").access("hasRole('ROLE_HOST)")  // host = member
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN)")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login");
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
