package com.demo.cashierapp;

import com.demo.cashierapp.api.service.employee.EmployeeApiService;
import com.demo.cashierapp.api.service.product.ProductApiService;
import com.demo.cashierapp.api.service.supplier.SupplierApiService;
import com.demo.cashierapp.entity.Role;
import com.demo.cashierapp.model.apiService.employee.CreateEmployeeRequestModel;
import com.demo.cashierapp.model.apiService.product.CreateProductRequestModel;
import com.demo.cashierapp.model.apiService.supplier.CreateSupplierRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeApiService employeeService, SupplierApiService supplierService, ProductApiService productService) {

        return args -> {

//            EMPLOYEES
            log.info("Preloading " + employeeService.create(
                            new CreateEmployeeRequestModel(
                                    "ruzanna",
                                    "Ruzanna",
                                    "Zohrabyan",
                                    "Q!w2e3r4",
                                    Arrays.asList(Role.CASHIER)
                            )
                    )
            );

            log.info("Preloading " + employeeService.create(
                            new CreateEmployeeRequestModel(
                                    "julieta",
                                    "Julieta",
                                    "Aghakaryan",
                                    "Q!w2e3r4",
                                    Arrays.asList(Role.ADMIN)
                            )
                    )
            );

            log.info("Preloading " + employeeService.create(
                            new CreateEmployeeRequestModel(
                                    "marina",
                                    "Marina",
                                    "Zakaryan",
                                    "Q!w2e3r4",
                                    Arrays.asList(Role.ADMIN)
                            )
                    )
            );
            log.info("Preloading " + employeeService.create(
                            new CreateEmployeeRequestModel(
                                    "ruben",
                                    "Ruben",
                                    "Balayan",
                                    "Q!w2e3r4",
                                    Arrays.asList(Role.ADMIN)
                            )
                    )
            );

//            SUPPLIERS
            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Daroink",
                                    "Ashot Minasyan",
                                    "1 Sevani str., Yerevan, Armenia",
                                    "096959595"
                            )
                    )
            );

            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Ani Product",
                                    "Karen Karapetyan",
                                    "15 Charentsi str., Yerevan, Armenia",
                                    "096655595"
                            )
                    )
            );

//            PRODUCTS
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Ani Product",
                                    "Ani",
                                    "87984512",
                                    "Bajak Vanilayin",
                                    "Ice Cream, Bajak Vanilayin",
                                    50,
                                    "peace",
                                    new BigDecimal(100),
                                    new BigDecimal(150)
                            )
                    )
            );

            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Daroink",
                                    "Daroink",
                                    "12345686",
                                    "Aghi dzoghik",
                                    "Aghi dzoghik, Daroink",
                                    100,
                                    "peace",
                                    new BigDecimal(150),
                                    new BigDecimal(220)
                            )
                    )
            );

        };
    }


}
