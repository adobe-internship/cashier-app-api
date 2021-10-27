package com.demo.cashierapp.model.apiService.sale;

import com.demo.cashierapp.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleDetailsResponseModel{
    private String username;
    private BigDecimal amount;
    private String uuid;
    private Date date;



}
