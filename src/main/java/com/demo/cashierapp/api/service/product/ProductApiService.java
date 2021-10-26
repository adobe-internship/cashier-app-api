package com.demo.cashierapp.api.service.product;

import com.demo.cashierapp.model.apiService.product.*;

import java.util.List;

public interface ProductApiService {
    ProductDetailsResponseModel create(CreateProductRequestModel createProductRequestModel);

    List<ProductDetailsResponseModel> getAll();

    ProductDetailsResponseModel getProductByBarcode(String barcode);

    BuyProductResponseModel buyProduct(BuyProductRequestModel model);

    void returnProduct(ReturnProductRequestModel model);

    void deleteByBarcode(String barcode);
}
