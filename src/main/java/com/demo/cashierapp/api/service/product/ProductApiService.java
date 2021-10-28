package com.demo.cashierapp.api.service.product;

import com.demo.cashierapp.model.apiService.product.*;

import java.util.List;

public interface ProductApiService {
    ProductDetailsResponseModel create(CreateProductRequestModel createProductRequestModel);

    List<ProductDetailsResponseModel> getAll();

    ProductDetailsResponseModel update(UpdateProductRequestModel model);

    BuyProductResponseModel buyProduct(BuyProductRequestModel model);

    void returnProduct(ReturnProductRequestModel model);

    void deleteByBarcode(String barcode);

    ProductDetailsResponseModel getByBarcode(String barcode);
}
