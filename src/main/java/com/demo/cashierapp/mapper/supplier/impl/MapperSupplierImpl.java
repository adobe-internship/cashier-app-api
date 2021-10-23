package com.demo.cashierapp.mapper.supplier.impl;

import com.demo.cashierapp.mapper.supplier.MapperSupplier;
import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.model.service.supplier.CreateSupplierParams;
import org.springframework.stereotype.Component;

@Component
public class MapperSupplierImpl implements MapperSupplier {
    @Override
    public CreateSupplierParams mapToCreateSupplierParams(CreateSupplierRequestModel createSupplierRequestModel) {
        return new CreateSupplierParams(
                createSupplierRequestModel.getName(),
                createSupplierRequestModel.getContactName(),
                createSupplierRequestModel.getAddress(),
                createSupplierRequestModel.getPhone()
        );
    }
}
