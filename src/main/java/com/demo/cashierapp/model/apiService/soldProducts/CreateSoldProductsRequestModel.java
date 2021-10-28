package com.demo.cashierapp.model.apiService.soldProducts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSoldProductsRequestModel {
    private String barcode;
    private Integer quantity;
    private BigDecimal costPrice;
    private BigDecimal salePrice;
}
