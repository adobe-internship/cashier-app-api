package com.demo.cashierapp.mapper.supplier;

import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.model.service.supplier.CreateSupplierParams;

public interface MapperSupplier {
    CreateSupplierParams mapToCreateSupplierParams(CreateSupplierRequestModel createSupplierRequestModel);

}
