package com.demo.cashierapp.entity;


import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "supplier")
@ToString
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIER_SEQ_GEN")
    @SequenceGenerator(name = "SUPPLIER_SEQ_GEN", sequenceName = "SUPPLIER_ID_GEN", allocationSize = 1)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public Supplier(String name, String contactName, String address, String phone) {
        this.name = name;
        this.contactName = contactName;
        this.address = address;
        this.phone = phone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        return new EqualsBuilder()
                .append(getName(), supplier.getName())
                .append(getContactName(), supplier.getContactName())
                .append(getAddress(), supplier.getAddress())
                .append(getPhone(), supplier.getPhone())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .append(getContactName())
                .append(getAddress())
                .append(getPhone())
                .toHashCode();
    }
}
