package com.demo.cashierapp.api.service.response.builder;

import com.demo.cashierapp.model.apiService.saleProductInfo.SaleProductInfoDetailsResponseModel;

public interface SaleProductInfoResponseModelBuilder {

    SaleProductInfoDetailsResponseModel build(Long id);
}
