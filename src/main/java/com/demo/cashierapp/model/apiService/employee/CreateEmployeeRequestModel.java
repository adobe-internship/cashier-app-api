package com.demo.cashierapp.model.apiService.employee;

import com.demo.cashierapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateEmployeeRequestModel extends BaseEmployee {
    private String password;
    private List<Role> roles;
}
