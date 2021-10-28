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
                                    "marina",
                                    "Marina",
                                    "Zakaryan",
                                    "Q!w2e3r4",
                                    Arrays.asList(Role.ROLE_ADMIN)
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
            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Alpen Gold",
                                    "Armine Srapyan",
                                    "20 Khorenatsi str., Yerevan, Armenia",
                                    "099876556"
                            )
                    )
            );
            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Kleopatra",
                                    "Srapyon Gasparyan",
                                    "99/2 Moskovyan str., Yerevan, Armenia",
                                    "099871232"
                            )
                    )
            );
            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Lori",
                                    "Vazgen Epremyan",
                                    "12 Nar-Dos str., Yerevan, Armenia",
                                    "055675412"
                            )
                    )
            );
            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Araqs",
                                    "Aram Gevorgyan",
                                    "10 Vardananc str., Hrazdan, Armenia",
                                    "096778899"
                            )
                    )
            );
            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Marianna",
                                    "Mariam Tumanyan",
                                    "26 Tigran Mets str., Yerevan, Armenia",
                                    "091233244"
                            )
                    )
            );
            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Calve",
                                    "Tigran Tumanyan",
                                    "20 Charents str., Yerevan, Armenia",
                                    "055676555"
                            )
                    )
            );

            log.info("Preloading " + supplierService.create(
                            new CreateSupplierRequestModel(
                                    "Byuregh",
                                    "Vahagn Ghambaryan",
                                    "54 Tigran Mets str., Yerevan, Armenia",
                                    "099665423"
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
                                    "piece",
                                    new BigDecimal(100),
                                    new BigDecimal(150)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Marianna",
                                    "Marianna",
                                    "85454443",
                                    "Matsun",
                                    "Matsun, 500ml",
                                    20,
                                    "piece",
                                    new BigDecimal(395),
                                    new BigDecimal(470)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Byuregh",
                                    "Byuregh",
                                    "85487623",
                                    "Water",
                                    "Water, 500ml",
                                    150,
                                    "piece",
                                    new BigDecimal(105),
                                    new BigDecimal(150)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Byuregh",
                                    "Byuregh",
                                    "85487683",
                                    "Water",
                                    "Water, 1l",
                                    67,
                                    "piece",
                                    new BigDecimal(145),
                                    new BigDecimal(190)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Byuregh",
                                    "Byuregh",
                                    "85487624",
                                    "Water",
                                    "Water, 1.5l",
                                    34,
                                    "piece",
                                    new BigDecimal(200),
                                    new BigDecimal(230)
                            )
                    )
            );

            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Marianna",
                                    "Marianna",
                                    "85454487",
                                    "Milk",
                                    "Cow milk, 1l",
                                    15,
                                    "litre",
                                    new BigDecimal(415),
                                    new BigDecimal(500)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Marianna",
                                    "Marianna",
                                    "85454889",
                                    "Milk",
                                    "Milk, 500ml",
                                    10,
                                    "piece",
                                    new BigDecimal(285),
                                    new BigDecimal(320)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Marianna",
                                    "Marianna",
                                    "85454888",
                                    "Cottage cheese",
                                    "Cottage cheese, 100g",
                                    15,
                                    "piece",
                                    new BigDecimal(175),
                                    new BigDecimal(300)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Marianna",
                                    "Marianna",
                                    "85454777",
                                    "Cottage cheese",
                                    "Cottage cheese, 200g",
                                    12,
                                    "piece",
                                    new BigDecimal(295),
                                    new BigDecimal(370)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Marianna",
                                    "Marianna",
                                    "85423177",
                                    "Sour cream",
                                    "Sour cream, 500g",
                                    15,
                                    "piece",
                                    new BigDecimal(475),
                                    new BigDecimal(560)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Marianna",
                                    "Marianna",
                                    "89344321",
                                    "Sour cream",
                                    "Sour cream, 250g",
                                    15,
                                    "piece",
                                    new BigDecimal(265),
                                    new BigDecimal(380)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Calve",
                                    "Calve",
                                    "85454879",
                                    "Mayonnaise",
                                    "Mayonnaise, 500g",
                                    15,
                                    "piece",
                                    new BigDecimal(385),
                                    new BigDecimal(410)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Calve",
                                    "Calve",
                                    "85454809",
                                    "Ketchup",
                                    "Ketchup, 500g",
                                    20,
                                    "piece",
                                    new BigDecimal(345),
                                    new BigDecimal(420)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Araqs",
                                    "Araqs",
                                    "88412732",
                                    "Egg",
                                    "Chicken egg",
                                    200,
                                    "piece",
                                    new BigDecimal(30),
                                    new BigDecimal(50)
                            )
                    )
            );
            log.info("Preloading " + productService.create(
                            new CreateProductRequestModel(
                                    "Lori",
                                    "Lori",
                                    "87289312",
                                    "Lori cheese",
                                    "Lori salted cheese",
                                    20,
                                    "kg",
                                    new BigDecimal(1800),
                                    new BigDecimal(2100)
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
                                    "piece",
                                    new BigDecimal(150),
                                    new BigDecimal(220)
                            )
                    )
            );

            log.info("Preloading" + productService.create(
                            new CreateProductRequestModel(
                                    "Alpen Gold",
                                    "Alpen Gold",
                                    "7622201450564",
                                    "Chocalate bar",
                                    "Milk chocolate",
                                    20,
                                    "piece",
                                    new BigDecimal(360),
                                    new BigDecimal(480)

                            )
                    )
            );
            log.info("Preloading" + productService.create(
                            new CreateProductRequestModel(
                                    "Kleopatra",
                                    "Jino",
                                    "6922868285969",
                                    "Skincare Wipes",
                                    "10 sheets",
                                    10,
                                    "piece",
                                    new BigDecimal(100),
                                    new BigDecimal(120)

                            )
                    )
            );

        };
    }


}

