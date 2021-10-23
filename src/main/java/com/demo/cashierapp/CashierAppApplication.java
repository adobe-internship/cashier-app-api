package com.demo.cashierapp;

import com.demo.cashierapp.entity.Supplier;
import com.demo.cashierapp.repository.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CashierAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashierAppApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(SupplierRepository supplierRepository){
		return args -> {
			Supplier supplier=new Supplier("name ", "name", "adress", "phone");
			supplierRepository.save(supplier);
		};
	}

}
