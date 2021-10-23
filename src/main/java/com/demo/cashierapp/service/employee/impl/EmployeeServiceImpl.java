package com.demo.cashierapp.service.employee.impl;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.model.service.employee.CreateEmployeeParams;
import com.demo.cashierapp.repository.EmployeeRepository;
import com.demo.cashierapp.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee create(CreateEmployeeParams createEmployeeParams) {
        final String salt = BCrypt.gensalt(10);
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(createEmployeeParams.getFirstName());
        newEmployee.setLastName(createEmployeeParams.getLastName());
        newEmployee.setUsername(createEmployeeParams.getUsername());
        newEmployee.setPassword(BCrypt.hashpw(createEmployeeParams.getPassword(), salt));
        return employeeRepository.save(newEmployee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        final Optional<Employee> entity = employeeRepository.findEmployeeByUsername(username);
        if (entity.isEmpty()) {
            throw new IllegalArgumentException("Employee does not exist");
        }
        return entity.get();
    }

    @Override
    public void deleteByUsername(String username) {
        final Employee employee = this.getEmployeeByUsername(username);
        employeeRepository.deleteById(employee.getId());
    }

    @Override
    public boolean usernameExists(String username) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByUsername(username);
        return employeeOptional.isPresent();
    }
}