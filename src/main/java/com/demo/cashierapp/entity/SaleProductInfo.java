package com.demo.cashierapp.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "sale")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SaleProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SEQ_GEN")
    @SequenceGenerator(name = "SALE_SEQ_GEN", sequenceName = "SALE_ID_SEQ", allocationSize = 1)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;

    @OneToOne
    @JoinColumn(name = "product_info_id", referencedColumnName = "id")
    private ProductInfo productInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SaleProductInfo that = (SaleProductInfo) o;

        return new EqualsBuilder().append(Id, that.Id).append(sale, that.sale).append(productInfo, that.productInfo).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(Id).append(sale).append(productInfo).toHashCode();
    }
}
