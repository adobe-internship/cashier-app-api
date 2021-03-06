package com.demo.cashierapp.model.service.product;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateProductParams {
    private final String supplier;
    private final String brand;
    private final String barcode;
    private final String productName;
    private final String productDescription;
    private final Integer quantity;
    private final String unitOfMeasurement;
    private final BigDecimal costPrice;
    private final BigDecimal salePrice;

    public CreateProductParams(
            String supplier, String brand, String barcode, String productName,
            String productDescription, int quantity, String unitOfMeasurement,
            BigDecimal costPrice, BigDecimal salePrice
    ) {
        this.supplier = supplier;
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
