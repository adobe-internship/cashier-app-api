package com.demo.cashierapp.model.apiService.product;

import com.demo.cashierapp.entity.Supplier;
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
    private Supplier supplier;
    private String brand;
    private String barcode;
    private String productName;
    private String productDescription;
    private int quantity;
    private String unitOfMeasurement;
    private BigDecimal costPrice;
    private BigDecimal salePrice;
}
