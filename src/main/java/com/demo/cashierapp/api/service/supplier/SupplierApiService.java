package com.demo.cashierapp.api.service.supplier;

import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import com.demo.cashierapp.model.apiService.supplier.SupplierDetailsResponseModel;
import com.demo.cashierapp.model.apiService.supplier.UpdateSupplierRequestModel;

import java.util.List;

public interface SupplierApiService {
    SupplierDetailsResponseModel create(CreateSupplierRequestModel createSupplierRequestModel);

    List<SupplierDetailsResponseModel> getAll();

    SupplierDetailsResponseModel getByName(String name);

    void deleteByName(String name);

    SupplierDetailsResponseModel update(UpdateSupplierRequestModel updateSupplierRequestModel);
}
