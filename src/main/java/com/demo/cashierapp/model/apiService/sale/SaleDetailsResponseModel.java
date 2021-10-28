package com.demo.cashierapp.model.apiService.sale;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.SaleSummary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleDetailsResponseModel{
    private String uuid;
    private LocalDateTime dateTime;
    private String username;
    private BigDecimal amount;
}
