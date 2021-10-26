package com.demo.cashierapp.model.apiService.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyProductResponseModel {
    private String brand;
    private String barcode;
    private String productName;
    private String productDescription;
    private Integer quantity;
    private String unitOfMeasurement;
    private BigDecimal salePrice;
}
