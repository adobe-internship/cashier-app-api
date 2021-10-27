package com.demo.cashierapp.mapper.supplier;

import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.model.apiService.supplier.SupplierUpdateRequestModel;
import com.demo.cashierapp.model.service.supplier.CreateSupplierParams;
import com.demo.cashierapp.model.service.supplier.SupplierUpdateParams;

public interface MapperSupplier {
    CreateSupplierParams mapToCreateSupplierParams(CreateSupplierRequestModel createSupplierRequestModel);

    SupplierUpdateParams mapToCreateSupplierParams(SupplierUpdateRequestModel supplierUpdateRequestModel);

}
