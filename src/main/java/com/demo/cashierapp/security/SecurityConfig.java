package com.demo.cashierapp.security;

import com.demo.cashierapp.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();
//                .antMatchers("/auth/login").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/product/buy").hasRole("CASHIER")
//                .antMatchers(HttpMethod.GET, "/api/product/return").hasRole("CASHIER")
//                .antMatchers(HttpMethod.POST, "/api/sale").hasRole("CASHIER")
//                .anyRequest().hasRole("ADMIN")
//                .and()
//                .logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles(Role.ADMIN.name());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
