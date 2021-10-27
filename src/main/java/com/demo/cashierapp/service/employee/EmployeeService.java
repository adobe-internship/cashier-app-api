package com.demo.cashierapp.service.employee;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.model.service.employee.CreateEmployeeParams;
import com.demo.cashierapp.model.service.employee.UpdateEmployeeParams;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeParams createEmployeeParams);

    Employee update(UpdateEmployeeParams updateEmployeeParams);

    List<Employee> getAll();

    Employee getEmployeeByUsername(String username);

    boolean usernameExists(String username);

    void deleteByUsername(String username);


}
