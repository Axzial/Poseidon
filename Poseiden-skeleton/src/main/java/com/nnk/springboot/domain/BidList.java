package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
public class BidList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String account;

    @NotBlank
    String type;

    Double bidQuantity;

    Double askQuantity;

    Double bid;

    Double ask;

    @NotBlank
    String benchmark;

    Timestamp bidListDate;

    @NotBlank
    String commentary;

    @NotBlank
    String security;

    @NotBlank
    String status;

    @NotBlank
    String trader;

    @NotBlank
    String book;

    @NotBlank
    String creationName;

    Timestamp creationDate;

    @NotBlank
    String revisionName;

    Timestamp revisionDate;

    @NotBlank
    String dealName;

    @NotBlank
    String dealType;

    @NotBlank
    String sourceListId;

    @NotBlank
    String side;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BidList bidList = (BidList) o;
        return id != null && Objects.equals(id, bidList.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
