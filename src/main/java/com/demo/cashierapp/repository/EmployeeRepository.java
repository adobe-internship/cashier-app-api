package com.demo.cashierapp.repository;

import com.demo.cashierapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByUsername(String username);

    Employee deleteEmployeeByUsername(String username);

    Optional<Employee> findEmployeeByUsernameAndAndPassword(String username, String password);

}
