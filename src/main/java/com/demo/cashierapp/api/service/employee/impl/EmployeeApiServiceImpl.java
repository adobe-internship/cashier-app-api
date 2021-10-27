package com.demo.cashierapp.api.service.employee.impl;

import com.demo.cashierapp.api.service.employee.EmployeeApiService;
import com.demo.cashierapp.api.service.employee.EmployeeValidator;
import com.demo.cashierapp.api.service.response.builder.EmployeeDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.EmployeeRole;
import com.demo.cashierapp.entity.Role;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.exception.types.EmployeeValidationExceptionRequest;
import com.demo.cashierapp.mapper.employee.MapperEmployee;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.apiService.employee.EmployeeDetailsResponseModel;
import com.demo.cashierapp.model.apiService.employee.UpdateEmployeeRequestModel;
import com.demo.cashierapp.model.service.employee.UpdateEmployeeParams;
import com.demo.cashierapp.service.employee.EmployeeService;
import com.demo.cashierapp.service.role.EmployeeRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeApiServiceImpl implements EmployeeApiService {
    private final EmployeeService employeeService;
    private final EmployeeRoleService employeeRoleService;
    private final MapperEmployee mapperEmployee;
    private final EmployeeDetailsResponseModelBuilder employeeDetailsBuilder;
    private final EmployeeValidator employeeValidator;

    @Override
    public EmployeeDetailsResponseModel create(CreateEmployeeRequestModel createEmployeeRequestModel) {
        List<ErrorSubtype> errorSubtypes = employeeValidator.validate(createEmployeeRequestModel);
        if (!errorSubtypes.isEmpty()) {
            throw new EmployeeValidationExceptionRequest("Validation Error", errorSubtypes);
        }
        final Employee savedEmployee = employeeService.create(
                mapperEmployee.mapToCreateEmployeeParams(createEmployeeRequestModel)
        );

        List<EmployeeRole> employeeRoles = new ArrayList<>();
        for (Role role : createEmployeeRequestModel.getRoles()) {
            employeeRoles.add(
                    employeeRoleService.assign(savedEmployee.getUsername(), role)
            );
        }
        savedEmployee.setRoles(employeeRoles);
        return employeeDetailsBuilder.build(savedEmployee.getUsername());
    }

    @Override
    public List<EmployeeDetailsResponseModel> getAll() {
        final List<Employee> employees = employeeService.getAll();
        return employees.stream()
                .map(employee -> employeeDetailsBuilder.build(employee.getUsername()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDetailsResponseModel getByUsername(String username) {
        checkEmployeeByUsername(username);
        return employeeDetailsBuilder.build(username);
    }

    @Override
    public void deleteByUsername(String username) {
        checkEmployeeByUsername(username);
        employeeService.deleteByUsername(username);
    }

    @Override
    public EmployeeDetailsResponseModel update(UpdateEmployeeRequestModel updateEmployeeRequestModel) {
        List<ErrorSubtype> errorSubtypes = employeeValidator.validate(updateEmployeeRequestModel);
        if (!errorSubtypes.isEmpty()) {
            throw new EmployeeValidationExceptionRequest("Validation Error", errorSubtypes);
        }
        UpdateEmployeeParams updateEmployeeParams = mapperEmployee.mapToUpdateEmployeeParams(updateEmployeeRequestModel);
        Employee updatedEmployee = employeeService.update(updateEmployeeParams);

        return employeeDetailsBuilder.build(updatedEmployee.getUsername());
    }

    private void checkEmployeeByUsername(String username) {
        List<ErrorSubtype> errorSubtypes = employeeValidator.validate(username);
        if (!errorSubtypes.isEmpty()) {
            throw new EmployeeValidationExceptionRequest("Validation Error", errorSubtypes);
        }
    }
}
