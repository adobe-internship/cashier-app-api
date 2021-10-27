package com.demo.cashierapp.repository;

import com.demo.cashierapp.entity.Product;
import com.demo.cashierapp.entity.SaleProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaleProductInfoRepository  extends JpaRepository<SaleProductInfo, Long> {

}
