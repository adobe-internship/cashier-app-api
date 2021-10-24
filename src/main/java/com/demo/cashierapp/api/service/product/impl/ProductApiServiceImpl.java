package com.demo.cashierapp.api.service.product.impl;

import com.demo.cashierapp.api.service.product.ProductApiService;
import com.demo.cashierapp.api.service.product.ProductValidator;
import com.demo.cashierapp.api.service.response.builder.ProductDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.exception.types.ProductValidationException;
import com.demo.cashierapp.mapper.product.MapperProduct;
import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.apiService.product.ProductDetailsResponseModel;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import com.demo.cashierapp.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductApiServiceImpl implements ProductApiService {
    private final ProductService productService;
    private final ProductDetailsResponseModelBuilder productResponseBuilder;
    private final MapperProduct mapperProduct;
    private final ProductValidator productValidator;

    @Override
    public ProductDetailsResponseModel create(CreateProductRequestModel createProductRequestModel) {
        final List<ErrorSubtype> errors = productValidator.validate(createProductRequestModel);
        if (!errors.isEmpty()) {
            throw new ProductValidationException("Product does not validated. For more information see Errors", errors);
        }
        final CreateProductParams productParams = mapperProduct.mapToCreateProductParams(createProductRequestModel);
        final Product savedProduct = productService.create(productParams);
        return productResponseBuilder.build(savedProduct.getBarcode());
    }

    @Override
    public List<ProductDetailsResponseModel> getAll() {
        List<Product> products = productService.getAll();
        return products
                .stream()
                .map(product -> productResponseBuilder.build(product.getBarcode()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDetailsResponseModel getProductByBarcode(String barcode) {
        checkProductByBarcode(barcode);
        return productResponseBuilder.build(barcode);
    }

    @Override
    public void deleteByBarcode(String barcode) {
        checkProductByBarcode(barcode);
        productService.deleteProductByBarcode(barcode);
    }

    private void checkProductByBarcode(String barcode) {
        final List<ErrorSubtype> errors = productValidator.validate(barcode);
        if (!errors.isEmpty()) {
            throw new ProductValidationException("Product does not validated. For more information see Errors", errors);
        }
    }
}
