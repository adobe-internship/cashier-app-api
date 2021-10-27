package com.demo.cashierapp.model.apiService.saleProductInfo;


import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.model.apiService.productInfo.ProductInfoDetailsResponseModel;
import com.demo.cashierapp.model.apiService.sale.SaleDetailsResponseModel;
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
public class SaleProductInfoDetailsResponseModel{
     Sale sale;
     Product product;

}
