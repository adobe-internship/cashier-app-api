package com.demo.cashierapp.api.service.response.builder.impl;

import com.demo.cashierapp.api.service.response.builder.SaleDetailsResponseModelBuilder;
import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaleDetailsResponseModelBuilderImpl implements SaleDetailsResponseModelBuilder {
    @Override
    public SaleDetailsResponseModel build(String uuid) {

        return null;
    }
}
