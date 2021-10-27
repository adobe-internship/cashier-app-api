package com.demo.cashierapp.api.service.productInfo.impl;

import com.demo.cashierapp.api.service.product.ProductValidator;
import com.demo.cashierapp.api.service.productInfo.ProductInfoApiService;
import com.demo.cashierapp.api.service.response.builder.BuyProductResponseModelBuilder;
import com.demo.cashierapp.api.service.response.builder.ProductDetailsResponseModelBuilder;
import com.demo.cashierapp.api.service.response.builder.ProductInfoDetailsResponseModelBuilder;
import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.exception.types.ProductValidationExceptionRequest;
import com.demo.cashierapp.mapper.product.MapperProduct;
import com.demo.cashierapp.mapper.productInfo.MapperProductInfo;
import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.apiService.product.ProductDetailsResponseModel;
import com.demo.cashierapp.model.apiService.productInfo.CreateProductInfoRequestModel;
import com.demo.cashierapp.model.apiService.productInfo.ProductInfoDetailsResponseModel;
import com.demo.cashierapp.model.service.product.CreateProductParams;
import com.demo.cashierapp.model.service.productInfo.CreateProductInfoParams;
import com.demo.cashierapp.service.product.ProductService;
import com.demo.cashierapp.service.productInfo.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductInfoApiServiceImpl implements ProductInfoApiService {


    private final ProductInfoService productInfoService;
    private final ProductInfoDetailsResponseModelBuilder productInfoResponseBuilder;
    private final MapperProductInfo mapperProductInfo;

    @Override
    public ProductInfoDetailsResponseModel create(CreateProductInfoRequestModel createProductInfoRequestModel) {
        final CreateProductInfoParams productInfoParams = mapperProductInfo.mapToCreateProductInfoParams(createProductInfoRequestModel);
        final ProductInfo savedProductInfo = productInfoService.create(productInfoParams);

        return productInfoResponseBuilder.build(savedProductInfo.getProduct().getBarcode());

    }

    @Override
    public List<ProductInfoDetailsResponseModel> getAll() {
        List<ProductInfo> productInfos = productInfoService.getAll();
        return productInfos.
                stream()
                .map(productInfo -> productInfoResponseBuilder.build(productInfo.getProduct().getBarcode()))
                .collect(Collectors.toList());
    }
}
