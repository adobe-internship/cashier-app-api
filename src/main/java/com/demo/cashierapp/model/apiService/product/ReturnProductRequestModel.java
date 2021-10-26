package com.demo.cashierapp.model.apiService.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReturnProductRequestModel {
    private String barcode;
    private Integer quantity;
}
