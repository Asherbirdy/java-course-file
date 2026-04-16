package com.kucw.security.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails userTest1 = User
                .withUsername("test1")
                .password("{bcrypt}$2a$10$0HqW1WxGFwzDgb/Oy/VAp.sg7eEWLqXO2DEtpzHZopXQmvVXtP4Y.")
                .roles("USER","ADMIN")
                .build();

        UserDetails userTest2 = User
                .withUsername("test2")
                .password("{noop}222")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userTest1, userTest2);
    }

}
