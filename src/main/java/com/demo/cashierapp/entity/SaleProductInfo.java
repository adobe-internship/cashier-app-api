package com.demo.cashierapp.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "sale_product_info")
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

    @ManyToOne
    @JoinColumn(name = "sale_id", foreignKey = @ForeignKey(name = "FK_SALE_ID"))
    private Sale sale;

    @OneToOne
    @JoinColumn(name = "product_info_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_INFO_ID"))
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
