package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String account;
    String type;
    Double buyQuantity;
    Double sellQuantity;
    Double buyPrice;
    Double sellPrice;
    String benchmark;
    Timestamp tradeDate;
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

}
