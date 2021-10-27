package com.demo.cashierapp.api.service.sale.impl;

import com.demo.cashierapp.api.service.sale.SaleApiService;
import com.demo.cashierapp.model.apiService.sale.CreateSaleRequestModel;
import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SaleApiServiceImpl implements SaleApiService {

    @Override
    public SaleDetailsResponseModel create(CreateSaleRequestModel createSaleRequestModel) {
        return null;
    }

    @Override
    public List<SaleDetailsResponseModel> getAll() {
        return null;
    }
}
