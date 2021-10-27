package com.demo.cashierapp.api.service.sale;

import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;
import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;

import java.util.List;

public interface SaleApiService {
    SaleDetailsResponseModel create(CreateSaleRequestModel createSaleRequestModel);

    List<SaleDetailsResponseModel> getAll();
}
