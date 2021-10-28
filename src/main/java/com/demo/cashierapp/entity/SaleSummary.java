package com.demo.cashierapp.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "sale_summary")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SEQ_GEN")
    @SequenceGenerator(name = "SALE_SEQ_GEN", sequenceName = "SALE_ID_SEQ", allocationSize = 1)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "sold_product_id", foreignKey = @ForeignKey(name = "FK_SOLD_PRODUCT_ID"))
    private SoldProducts soldProduct;

    @ManyToOne
    @JoinColumn(name="sale_id", foreignKey = @ForeignKey(name = "FK_SALE_ID"))
    private Sale sale;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SaleSummary that = (SaleSummary) o;

        return new EqualsBuilder().append(getId(), that.getId()).append(getSoldProduct(), that.getSoldProduct()).append(getSale(), that.getSale()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSoldProduct())
                .append(getSale())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("soldProduct", soldProduct)
                .append("sale", sale)
                .toString();
    }
}
