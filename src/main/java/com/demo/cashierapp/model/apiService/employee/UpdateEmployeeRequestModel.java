package com.demo.cashierapp.model.apiService.employee;

import com.demo.cashierapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequestModel {
    private String username;
    private String password;;
}