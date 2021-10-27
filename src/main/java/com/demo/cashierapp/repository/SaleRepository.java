package com.demo.cashierapp.repository;


import com.demo.cashierapp.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
