package com.demo.cashierapp.security;

import com.demo.cashierapp.security.jwt.JwtAuthorization;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers("/employee/delete").hasRole("ADMIN")
                .antMatchers("/product/").hasRole("ADMIN")
                .antMatchers("/product").hasRole("ADMIN")
                .antMatchers("/supplier/").hasRole("ADMIN")
                .and()
                .addFilterBefore(new JwtAuthorization(), BasicAuthenticationFilter.class)
                .logout().permitAll();
    }
}