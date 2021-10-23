package com.demo.cashierapp.model.apiService.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseSupplier {

    private String name;
    private String contactName;
    private String address;
    private String phone;
}
