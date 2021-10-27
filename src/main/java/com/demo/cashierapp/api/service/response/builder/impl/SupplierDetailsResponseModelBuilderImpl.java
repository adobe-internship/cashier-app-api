package com.demo.cashierapp.api.service.response.builder.impl;

import com.demo.cashierapp.api.service.response.builder.SupplierDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.Supplier;
import com.demo.cashierapp.model.apiService.supplier.SupplierDetailsResponseModel;
import com.demo.cashierapp.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierDetailsResponseModelBuilderImpl implements SupplierDetailsResponseModelBuilder {


    private final SupplierService supplierService;

    @Override
    public SupplierDetailsResponseModel build(String name) {
        final Supplier supplier = supplierService.getSupplierByName(name);

        final SupplierDetailsResponseModel supplierDetailsResponseModel = new SupplierDetailsResponseModel();
        supplierDetailsResponseModel.setName(supplier.getName());
        supplierDetailsResponseModel.setContactName(supplier.getContactName());
        supplierDetailsResponseModel.setAddress(supplier.getAddress());
        supplierDetailsResponseModel.setPhone(supplier.getPhone());

        return supplierDetailsResponseModel;
    }
}
