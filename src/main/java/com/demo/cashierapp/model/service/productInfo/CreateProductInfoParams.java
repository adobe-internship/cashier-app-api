package com.demo.cashierapp.model.service.productInfo;


import com.demo.cashierapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductInfoParams {

    private Product product;
    private int quantity;


}
