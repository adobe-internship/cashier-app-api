package com.demo.cashierapp.model.apiService.product;

import com.demo.cashierapp.model.apiService.supplier.SupplierDetailsResponseModel;
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
public class ProductDetailsResponseModel extends BaseProduct {
    SupplierDetailsResponseModel supplier;
}
