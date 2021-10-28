package com.demo.cashierapp.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sold_products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SoldProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOLD_PRODUCTS_SEQ_GEN")
    @SequenceGenerator(name = "SOLD_PRODUCTS_SEQ_GEN", sequenceName = "SOLD_PRODUCTS_ID_SEQ", allocationSize = 1)
    private Long Id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_ID"))
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "cost_price")
    private BigDecimal costPrice;

    @Column(name="sale_price")
    private BigDecimal salePrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SoldProducts that = (SoldProducts) o;

        return new EqualsBuilder().append(getId(), that.getId()).append(getProduct(), that.getProduct()).append(getQuantity(), that.getQuantity()).append(getCostPrice(), that.getCostPrice()).append(getSalePrice(), that.getSalePrice()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getProduct()).append(getQuantity()).append(getCostPrice()).append(getSalePrice()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("Id", Id)
                .append("product", product)
                .append("quantity", quantity)
                .append("costPrice", costPrice)
                .append("salePrice", salePrice)
                .toString();
    }
}
