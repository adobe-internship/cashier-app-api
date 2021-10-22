package com.demo.cashierapp.api.service.product;

import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.apiService.product.ProductDetailsModel;

import java.util.List;

public interface ProductApiService {
    ProductDetailsModel create(CreateProductRequestModel createProductRequestModel);

    List<ProductDetailsModel> getAll();

    ProductDetailsModel getProductByBarcode(String barcode);
}
