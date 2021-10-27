package com.demo.cashierapp.model.apiService.sale;

import com.demo.cashierapp.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleRequestModel  {
    private String username;
    private BigDecimal amount;
}
