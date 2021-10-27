package com.demo.cashierapp.model.service.saleProductInfo;

import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleProductInfoParams {

    private Sale sale;
    private ProductInfo productInfo;
}
