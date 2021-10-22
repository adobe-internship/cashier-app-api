package com.demo.cashierapp.service.role.impl;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.EmployeeRole;
import com.demo.cashierapp.entity.Role;
import com.demo.cashierapp.repository.EmployeeRoleRepository;
import com.demo.cashierapp.service.employee.EmployeeService;
import com.demo.cashierapp.service.role.EmployeeRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    private final EmployeeRoleRepository employeeRoleRepository;
    private final EmployeeService employeeService;

    @Override
    public EmployeeRole assign(String username, Role role) {
        final Employee employee = employeeService.getEmployeeByUsername(username);
        final EmployeeRole employeeRole = new EmployeeRole();
        employeeRole.setEmployee(employee);
        employeeRole.setRole(role);
        return employeeRoleRepository.save(employeeRole);
    }

    @Override
    public List<Role> getAllRolesByUsername(String username) {
        final List<EmployeeRole> employeeRoles = employeeRoleRepository.findAllByEmployee_Username(username);
        return employeeRoles.stream().map(EmployeeRole::getRole).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeRole> getAllEmployeeRolesByUsername(String username) {
        return employeeRoleRepository.findAllByEmployee_Username(username);
    }
}
