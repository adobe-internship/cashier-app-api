package com.demo.cashierapp.model.service.supplier;

import lombok.Getter;

@Getter
public class CreateSupplierParams {

        private final String name;
        private final String contact_name;
        private final String address;
        private final String phone;

    public CreateSupplierParams(String name, String contact_name, String address, String phone) {
        if (name == null) {
            throw new IllegalArgumentException("The username should not be null");
        }
        this.name = name;
        this.contact_name = contact_name;
        this.address = address;
        this.phone = phone;
    }
}
