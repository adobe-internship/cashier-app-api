package com.demo.cashierapp.api.service.response.builder.impl;

import com.demo.cashierapp.api.service.response.builder.SaleDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.entity.SaleSummary;
import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;
import com.demo.cashierapp.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SaleDetailsResponseModelBuilderImpl implements SaleDetailsResponseModelBuilder {
    private final SaleService saleService;

    @Override
    public SaleDetailsResponseModel build(String uuid) {
        final Sale savedSale = saleService.getSaleByUUID(uuid);
        final SaleDetailsResponseModel model = new SaleDetailsResponseModel();
        model.setUuid(savedSale.getUuid());
        model.setEmployee(savedSale.getEmployee());
        model.setSaleSummaryList(savedSale.getSaleSummaryList());
        model.setAmount(savedSale.getAmount());
        model.setDateTime(savedSale.getSaleTime());

        return model;
    }
}
