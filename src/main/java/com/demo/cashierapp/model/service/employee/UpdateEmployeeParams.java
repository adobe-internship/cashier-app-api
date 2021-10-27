package com.demo.cashierapp.model.service.employee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateEmployeeParams {
    private final String username;
    private final String password;

    public UpdateEmployeeParams(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
