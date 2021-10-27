package com.demo.cashierapp.security;

import com.demo.cashierapp.utils.jwt.JwtAuthorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
                .antMatchers("/api/auth/login").anonymous()
//                .antMatchers(HttpMethod.GET, "/api/product/buy").hasRole("CASHIER")
                .antMatchers("/api/product/buy").hasRole("CASHIER")
                .antMatchers("/api/product/return").hasRole("CASHIER")
//                TODO: Add exact path for sale controller
                .antMatchers("/api/sale/").hasRole("CASHIER")
                .anyRequest().hasRole("ADMIN")
                .and()
                .addFilterAt(new JwtAuthorization(), BasicAuthenticationFilter.class)
                .logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("ADMIN");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
