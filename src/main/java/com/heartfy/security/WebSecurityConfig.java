package com.heartfy.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/css/**", "/img/**", "/js/**", "/vendor/**", "/error").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/doctor/**").hasRole("DOCTOR")
                    .antMatchers("/nurse/**").hasRole("NURSE")
                    .antMatchers("/patient/**").hasRole("PATIENT")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login").permitAll();
    }
}
