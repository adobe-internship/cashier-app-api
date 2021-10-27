package com.demo.cashierapp.model.apiService.supplier;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SupplierUpdateRequestModel {
    private String name;
    private String contactName;
    private String address;
    private String phone;

}
