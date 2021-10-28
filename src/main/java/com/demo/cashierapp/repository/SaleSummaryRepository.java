package com.demo.cashierapp.repository;

import com.demo.cashierapp.entity.SaleSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleSummaryRepository extends JpaRepository<SaleSummary, Long> {

}
