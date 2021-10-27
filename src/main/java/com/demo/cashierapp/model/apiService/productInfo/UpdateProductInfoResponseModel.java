package com.demo.cashierapp.model.apiService.productInfo;

import com.demo.cashierapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateProductInfoResponseModel {
    private Product product;
    private int quantity;
}
