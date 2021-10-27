package com.demo.cashierapp.model.apiService.employee;

import com.demo.cashierapp.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateEmployeeRequestModel extends BaseEmployee {

    public CreateEmployeeRequestModel(String username, String firstName, String lastName, String password, List<Role> roles) {
        super(username, firstName, lastName);
        this.password = password;
        this.roles = roles;
    }

    private String password;
    private List<Role> roles;
}
