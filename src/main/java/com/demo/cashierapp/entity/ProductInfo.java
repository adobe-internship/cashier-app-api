package com.demo.cashierapp.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "product_info")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SEQ_GEN")
    @SequenceGenerator(name = "SALE_SEQ_GEN", sequenceName = "SALE_ID_SEQ", allocationSize = 1)
    private long Id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @OneToOne(mappedBy = "productInfo")
    private SaleProductInfo saleProductInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductInfo that = (ProductInfo) o;

        return new EqualsBuilder().append(Id, that.Id).append(quantity, that.quantity).append(product, that.product).append(saleProductInfo, that.saleProductInfo).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(Id).append(product).append(quantity).append(saleProductInfo).toHashCode();
    }
}
