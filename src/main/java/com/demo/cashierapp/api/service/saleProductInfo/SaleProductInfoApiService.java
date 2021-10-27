package com.demo.cashierapp.api.service.saleProductInfo;


import com.demo.cashierapp.model.apiService.saleProductInfo.CreateSaleProductInfoRequestModel;
import com.demo.cashierapp.model.apiService.saleProductInfo.SaleProductInfoDetailsResponseModel;

import java.util.List;

public interface SaleProductInfoApiService {
    SaleProductInfoDetailsResponseModel create(CreateSaleProductInfoRequestModel createSaleProductInfoRequestModel);

    List<SaleProductInfoDetailsResponseModel> getAll();
}
