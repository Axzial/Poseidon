package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
public class BidList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer BidListId;
    String account;
    String type;
    Double bidQuantity;
    Double askQuantity;
    Double bid;
    Double ask;
    String benchmark;
    Timestamp bidListDate;
    String commentary;
    String security;
    String status;
    String trader;
    String book;
    String creationName;
    Timestamp creationDate;
    String revisionName;
    Timestamp revisionDate;
    String dealName;
    String dealType;
    String sourceListId;
    String side;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BidList bidList = (BidList) o;
        return BidListId != null && Objects.equals(BidListId, bidList.BidListId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
