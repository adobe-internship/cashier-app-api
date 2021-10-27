package com.demo.cashierapp.api.service.productInfo;

import com.demo.cashierapp.model.apiService.productInfo.CreateProductInfoRequestModel;
import com.demo.cashierapp.model.apiService.productInfo.ProductInfoDetailsResponseModel;

import java.util.List;

public interface ProductInfoApiService {
    ProductInfoDetailsResponseModel create(CreateProductInfoRequestModel createProductInfoRequestModel);

    List<ProductInfoDetailsResponseModel> getAll();
}
