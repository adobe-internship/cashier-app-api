package com.demo.cashierapp.model.service.product;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UpdateProductParams {
    private final String supplier;
    private final String barcode;
    private final BigDecimal costPrice;
    private final BigDecimal salePrice;

    public UpdateProductParams(
            String supplier, String barcode, BigDecimal costPrice, BigDecimal salePrice
    ) {
        this.supplier = supplier;
        this.barcode = barcode;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }
}
