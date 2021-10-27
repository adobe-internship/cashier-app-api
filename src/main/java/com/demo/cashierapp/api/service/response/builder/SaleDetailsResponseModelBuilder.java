package com.demo.cashierapp.api.service.response.builder;

import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;

import java.util.UUID;

public interface SaleDetailsResponseModelBuilder {
    SaleDetailsResponseModel build(String uuid);
}
