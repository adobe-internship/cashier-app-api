package com.demo.cashierapp.api.service.product.impl;

import com.demo.cashierapp.api.service.product.ProductApiService;
import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.mapper.product.MapperProduct;
import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.apiService.product.ProductDetailsModel;
import com.demo.cashierapp.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductApiServiceImpl implements ProductApiService {
    private final ProductService productService;
    private final MapperProduct mapperProduct;

    @Override
    public ProductDetailsModel create(CreateProductRequestModel createProductRequestModel) {

        final Product savedProduct = productService.create(mapperProduct.mapToCreateProductParams(createProductRequestModel));
        return null;
    }

    @Override
    public List<ProductDetailsModel> getAll() {
        return null;
    }

    @Override
    public ProductDetailsModel getProductByBarcode(String barcode) {
        return null;
    }
}
