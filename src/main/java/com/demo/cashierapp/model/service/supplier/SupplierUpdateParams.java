package com.demo.cashierapp.model.service.supplier;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SupplierUpdateParams {
    private String name;
    private String concatName;
    private String address;
    private String phone;
}
