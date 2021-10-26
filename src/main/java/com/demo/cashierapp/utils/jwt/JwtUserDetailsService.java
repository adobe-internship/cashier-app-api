package com.demo.cashierapp.utils.jwt;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.service.employee.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
    private final EmployeeService employeeService;

    public JwtUserDetailsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = employeeService.getEmployeeByUsername(s);
        return null;
    }
}
