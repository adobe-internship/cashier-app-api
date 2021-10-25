package com.demo.cashierapp.model.apiService.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@NoArgsConstructor
@Getter
@Setter
public class CreateProductRequestModel extends BaseProduct {
    @JsonProperty("name")
    private String supplierName;

    public CreateProductRequestModel(String supplierName, String brand, String barcode, String productName, String productDescription,
                                     Integer quantity, String unitOfMeasurement, BigDecimal costPrice, BigDecimal salePrice) {
        super(brand, barcode, productName, productDescription, quantity, unitOfMeasurement, costPrice, salePrice);
        this.supplierName = supplierName;
    }

}
