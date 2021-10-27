package com.demo.cashierapp.model.apiService.saleProductInfo;


import com.demo.cashierapp.entity.ProductInfo;
import com.demo.cashierapp.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseSaleProductInfo {

    private Sale sale;
    private ProductInfo productInfo;

}
