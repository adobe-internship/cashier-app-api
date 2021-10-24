package com.demo.cashierapp.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GEN")
    @SequenceGenerator(name = "PRODUCT_SEQ_GEN", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplier_id", foreignKey = @ForeignKey(name = "FK_SUPPLIER_ID"))
    private Supplier supplier;

    @Column(name = "brand")
    private String brand;

    @Column(name = "barcode", nullable = false)
    private String barcode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;

    @Column(name = "cost_price")
    private BigDecimal costPrice;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(getQuantity(), product.getQuantity())
                .append(getSupplier(), product.getSupplier())
                .append(getBrand(), product.getBrand())
                .append(getBarcode(), product.getBarcode())
                .append(getProductName(), product.getProductName())
                .append(getProductDescription(), product.getProductDescription())
                .append(getUnitOfMeasurement(), product.getUnitOfMeasurement())
                .append(getCostPrice(), product.getCostPrice())
                .append(getSalePrice(), product.getSalePrice())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSupplier())
                .append(getBrand())
                .append(getBarcode())
                .append(getProductName())
                .append(getProductDescription())
                .append(getQuantity())
                .append(getUnitOfMeasurement())
                .append(getCostPrice())
                .append(getSalePrice())
                .toHashCode();
    }
}
