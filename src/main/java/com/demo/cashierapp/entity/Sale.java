package com.demo.cashierapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "sale")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"saleSummaryList"})

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SEQ_GEN")
    @SequenceGenerator(name = "SALE_SEQ_GEN", sequenceName = "SALE_ID_SEQ", allocationSize = 1)
    private Long Id;

    @Column(name = "uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "sale_date_time")
    private LocalDateTime saleTime = LocalDateTime.now();

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    private Employee employee;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
    private List<SaleSummary> saleSummaryList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        return new EqualsBuilder().append(getId(), sale.getId()).append(getUuid(), sale.getUuid()).append(getSaleTime(), sale.getSaleTime()).append(getAmount(), sale.getAmount()).append(getEmployee(), sale.getEmployee()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getUuid()).append(getSaleTime()).append(getAmount()).append(getEmployee()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("Id", Id)
                .append("uuid", uuid)
                .append("saleTime", saleTime)
                .append("amount", amount)
                .append("employee", employee)
                .append("saleSummaryList", saleSummaryList)
                .toString();
    }
}