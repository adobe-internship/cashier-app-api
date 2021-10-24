package com.demo.cashierapp.api.service.product.impl;

import com.demo.cashierapp.api.service.product.ProductValidator;
import com.demo.cashierapp.exception.ErrorSubtype;
import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.service.product.ProductService;
import com.demo.cashierapp.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductValidatorImpl implements ProductValidator {
    private final ProductService productService;
    private final SupplierService supplierService;

    @Override
    public List<ErrorSubtype> validate(CreateProductRequestModel requestModel) {
        List<ErrorSubtype> errors = new LinkedList<>();
        if (StringUtils.isEmpty(requestModel.getSupplierName())) {
            errors.add(ErrorSubtype.MISSING_SUPPLIER_NAME);
        } else if (!supplierService.nameExists(requestModel.getSupplierName())) {
            errors.add(ErrorSubtype.SUPPLIER_DOES_NOT_EXIST);
        }
        if (StringUtils.isEmpty(requestModel.getBarcode())) {
            errors.add(ErrorSubtype.MISSING_BARCODE);
        }
        if (StringUtils.isEmpty(requestModel.getProductName())) {
            errors.add(ErrorSubtype.MISSING_PRODUCT_NAME);
        }
        if (StringUtils.isEmpty(requestModel.getProductDescription())) {
            errors.add(ErrorSubtype.MISSING_PRODUCT_DESCRIPTION);
        }
        if (StringUtils.isEmpty(requestModel.getBrand())) {
            errors.add(ErrorSubtype.MISSING_BRAND);
        }
        if (requestModel.getQuantity() < 0) {
            errors.add(ErrorSubtype.NEGATIVE_VALUE);
        }
        if (StringUtils.isEmpty(requestModel.getUnitOfMeasurement())) {
            errors.add(ErrorSubtype.MISSING_MEASUREMENT);
        }
        if (requestModel.getCostPrice().compareTo(BigDecimal.ZERO) < 0 || requestModel.getSalePrice().compareTo(BigDecimal.ZERO) < 0) {
            errors.add(ErrorSubtype.NEGATIVE_VALUE);
        }
        return errors;
    }

    @Override
    public List<ErrorSubtype> validate(String barcode) {
        List<ErrorSubtype> errors = new LinkedList<>();
        if (StringUtils.isEmpty(barcode)) {
            errors.add(ErrorSubtype.MISSING_BARCODE);
        } else if (!productService.productExists(barcode)) {
            errors.add(ErrorSubtype.BARCODE_DOES_NOT_EXIST);
        }
        return errors;
    }
}
