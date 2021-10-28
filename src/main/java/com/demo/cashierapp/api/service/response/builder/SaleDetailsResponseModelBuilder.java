package com.demo.cashierapp.api.service.response.builder;

import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;

public interface SaleDetailsResponseModelBuilder {
    SaleDetailsResponseModel build(String uuid);
}
