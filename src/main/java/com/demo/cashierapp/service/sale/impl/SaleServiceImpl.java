package com.demo.cashierapp.service.sale.impl;

import com.demo.cashierapp.entity.Employee;
import com.demo.cashierapp.entity.Sale;
import com.demo.cashierapp.model.service.sale.CreateSaleParams;
import com.demo.cashierapp.repository.SaleRepository;
import com.demo.cashierapp.service.employee.EmployeeService;
import com.demo.cashierapp.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final EmployeeService employeeService;
    @Override
    public Sale create(CreateSaleParams createSaleParams) {
        final Sale newSale = new Sale();
        final Employee employee = employeeService.getEmployeeByUsername(createSaleParams.getUsername());
        newSale.setAmount(createSaleParams.getAmount());
        newSale.setEmployee(employee);
        return saleRepository.save(newSale);
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleByUUID(String uuid) {
        final Optional<Sale> entity = saleRepository.findSaleByUuid(uuid);
        return entity.get();
    }

}
