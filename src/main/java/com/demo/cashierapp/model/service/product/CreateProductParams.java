package com.demo.cashierapp.model.service.product;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateProductParams {
    private final String supplier_uid;
    private final String brand;
    private final String barcode;
    private final String productName;
    private final String productDescription;
    private final int quantity;
    private final String unitOfMeasurement;
    private final BigDecimal costPrice;
    private final BigDecimal salePrice;

    public CreateProductParams(
            String supplier_uid, String brand, String barcode, String productName,
            String productDescription, int quantity, String unitOfMeasurement,
            BigDecimal costPrice, BigDecimal salePrice
    ) {
        if (barcode == null) {
            throw new IllegalArgumentException("The barcode should not be null");
        }
        this.supplier_uid = supplier_uid;
        this.brand = brand;
        this.barcode = barcode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.unitOfMeasurement = unitOfMeasurement;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }
}
