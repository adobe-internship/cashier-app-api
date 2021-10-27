//package com.demo.cashierapp.api.service.productInfo.impl;
//
//import com.demo.cashierapp.api.service.productInfo.ProductInfoValidator;
//import com.demo.cashierapp.exception.ErrorSubtype;
//import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
//import com.demo.cashierapp.model.apiService.productInfo.CreateProductInfoRequestModel;
//import com.demo.cashierapp.service.product.ProductService;
//import com.demo.cashierapp.service.productInfo.ProductInfoService;
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.util.LinkedList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class ProductInfoValidatorImpl implements ProductInfoValidator {
//    private final ProductService productService;
//    private final ProductInfoService productInfoService;
//
//
//    @Override
//    public List<ErrorSubtype> validate(CreateProductInfoRequestModel requestModel) {
//        List<ErrorSubtype> errors = new LinkedList<>();
//        if(StringUtils.isEmpty(requestModel.get))
//       }
//
//
//
//    @Override
//    public List<ErrorSubtype> validate(String barcode) {
//        return null;
//    }
//}
