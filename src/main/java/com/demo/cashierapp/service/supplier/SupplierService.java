package com.demo.cashierapp.service.supplier;

import com.demo.cashierapp.entity.Supplier;
import com.demo.cashierapp.model.service.supplier.CreateSupplierParams;
import com.demo.cashierapp.model.service.supplier.SupplierUpdateParams;

import java.util.List;

public interface SupplierService {

    Supplier create(CreateSupplierParams createSupplierParams);

    List<Supplier> getAll();

    Supplier getSupplierByName(String name);

    boolean nameExists(String name);

    void deleteByName(String name);

    Supplier update(SupplierUpdateParams supplierUpdateParams);

}
