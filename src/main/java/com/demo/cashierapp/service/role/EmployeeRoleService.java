package com.demo.cashierapp.service.role;

import com.demo.cashierapp.entity.EmployeeRole;
import com.demo.cashierapp.entity.Role;

import java.util.List;


public interface EmployeeRoleService {
    EmployeeRole assign(String username, Role role);

    List<Role> getAllRolesByUsername(String username);

    //    ResponseEntity<EmployeeRole> getById(Long id);
//
    List<EmployeeRole> getAllEmployeeRolesByUsername(String username);
//
//    void delete(EmployeeRole employeeRole);
//
//    void deleteById(Long id);

}
