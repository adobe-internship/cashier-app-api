package com.demo.cashierapp.model.apiService.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseProduct {
    private String supplier_uid;
    private String brand;
    private String barcode;
    private String productName;
    private String productDescription;
    private int quantity;
    private String unitOfMeasurement;
    private BigDecimal costPrice;
    private BigDecimal salePrice;
}
