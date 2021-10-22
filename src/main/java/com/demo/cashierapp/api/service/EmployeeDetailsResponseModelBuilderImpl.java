package com.demo.cashierapp.api.service;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.Role;
import com.demo.cashierapp.model.apiService.employee.EmployeeDetailsResponseModel;
import com.demo.cashierapp.service.employee.EmployeeService;
import com.demo.cashierapp.service.role.EmployeeRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeDetailsResponseModelBuilderImpl implements EmployeeDetailsResponseModelBuilder {

    private final EmployeeService employeeService;
    private final EmployeeRoleService employeeRoleService;

    @Override
    public EmployeeDetailsResponseModel build(String username) {
        final Employee employee = employeeService.getEmployeeByUsername(username);
        final List<Role> roleList = employeeRoleService.getAllRolesByUsername(employee.getUsername());

        final EmployeeDetailsResponseModel employeeDetailsResponseModel = new EmployeeDetailsResponseModel();
        employeeDetailsResponseModel.setUsername(employee.getUsername());
        employeeDetailsResponseModel.setFirstName(employee.getFirstName());
        employeeDetailsResponseModel.setLastName(employee.getLastName());
        employeeDetailsResponseModel.setRoleList(roleList);

        return employeeDetailsResponseModel;
    }
}
