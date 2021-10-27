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
public class UpdateProductRequestModel {
    private String barcode;
    private String supplierName;
    private BigDecimal costPrice;
    private BigDecimal salePrice;
}
