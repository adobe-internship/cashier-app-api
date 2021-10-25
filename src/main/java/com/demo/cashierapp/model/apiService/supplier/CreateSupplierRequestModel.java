package com.demo.cashierapp.model.apiService.supplier;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CreateSupplierRequestModel extends BaseSupplier {
    public CreateSupplierRequestModel(String name, String contactName, String address, String phone) {
        super(name, contactName, address, phone);

    }
}
