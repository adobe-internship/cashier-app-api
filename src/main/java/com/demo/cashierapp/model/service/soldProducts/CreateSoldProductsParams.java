package com.demo.cashierapp.model.service.soldProducts;

import com.demo.cashierapp.entity.SaleSummary;
import com.demo.cashierapp.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSoldProductsParams {
    private String barcode;
    private Integer quantity;
    private BigDecimal costPrice;
    private BigDecimal salePrice;
}
