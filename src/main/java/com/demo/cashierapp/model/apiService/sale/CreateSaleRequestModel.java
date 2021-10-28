package com.demo.cashierapp.model.apiService.sale;

import com.demo.cashierapp.model.apiService.soldProducts.CreateSoldProductsRequestModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleRequestModel  {
    @JsonProperty("username")
    private String employeeUsername;
    @JsonProperty("totalOrderSum")
    private BigDecimal amount;
    @JsonProperty("orderList")
    private List<CreateSoldProductsRequestModel> soldProducts;
}