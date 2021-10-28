package com.demo.cashierapp.model.service.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateSaleParams {
    private final BigDecimal amount;
    private final String username;


}
