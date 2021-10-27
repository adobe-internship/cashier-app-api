package com.demo.cashierapp.model.apiService.productInfo;

import com.demo.cashierapp.entity.Product;
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
public class BaseProductInfo {

    private Product product;
    private int quantity;

}
