package com.demo.cashierapp.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "sale")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SEQ_GEN")
    @SequenceGenerator(name = "SALE_SEQ_GEN", sequenceName = "SALE_ID_SEQ", allocationSize = 1)
    private Long Id;

    @Column(name = "uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "sale_date_time")
    private Date saleTime = new Date();

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    private Employee employee;

    @OneToMany(mappedBy = "productInfo", cascade = CascadeType.ALL)
    private List<SaleProductInfo> saleProductInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        return new EqualsBuilder().append(amount, sale.amount).append(Id, sale.Id).append(uuid, sale.uuid).append(saleTime, sale.saleTime).append(employee, sale.employee).append(saleProductInfo, sale.saleProductInfo).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(Id).append(uuid).append(saleTime).append(amount).append(employee).append(saleProductInfo).toHashCode();
    }
}