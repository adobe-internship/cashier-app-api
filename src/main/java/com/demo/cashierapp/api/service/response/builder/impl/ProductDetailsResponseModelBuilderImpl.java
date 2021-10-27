package com.demo.cashierapp.api.service.response.builder.impl;

import com.demo.cashierapp.api.service.response.builder.ProductDetailsResponseModelBuilder;
import com.demo.cashierapp.api.service.response.builder.SupplierDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.model.apiService.product.ProductDetailsResponseModel;
import com.demo.cashierapp.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDetailsResponseModelBuilderImpl implements ProductDetailsResponseModelBuilder {
    private final ProductService productService;
    private final SupplierDetailsResponseModelBuilder supplierResponseBuilder;

    @Override
    public ProductDetailsResponseModel build(String barcode) {
        final Product product = productService.getProductByBarcode(barcode);
        final ProductDetailsResponseModel model = new ProductDetailsResponseModel();
        model.setSupplier(supplierResponseBuilder.build(product.getSupplier().getName()));
        model.setBarcode(product.getBarcode());
        model.setBrand(product.getBrand());
        model.setProductName(product.getProductName());
        model.setProductDescription(product.getProductDescription());
        model.setQuantity(product.getQuantity());
        model.setUnitOfMeasurement(product.getUnitOfMeasurement());
        model.setCostPrice(product.getCostPrice());
        model.setSalePrice(product.getSalePrice());

        return model;
    }
}
