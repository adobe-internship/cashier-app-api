package com.demo.cashierapp.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GEN")
    @SequenceGenerator(name = "PRODUCT_SEQ_GEN", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplier_id", foreignKey = @ForeignKey(name = "FK_SUPPLIER_ID"))
    private Supplier supplier;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "barcode", nullable = false)
    private String barcode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_of_measurement", nullable = false)
    private String unitOfMeasurement;

    @Column(name = "cost_price", nullable = false)
    private BigDecimal costPrice;

    @Column(name = "sale_price", nullable = false)
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("supplier", supplier)
                .append("brand", brand)
                .append("barcode", barcode)
                .append("productName", productName)
                .append("productDescription", productDescription)
                .append("quantity", quantity)
                .append("unitOfMeasurement", unitOfMeasurement)
                .append("costPrice", costPrice)
                .append("salePrice", salePrice)
                .toString();
    }
}
