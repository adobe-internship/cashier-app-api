package com.demo.cashierapp.repository;

import com.demo.cashierapp.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

}
