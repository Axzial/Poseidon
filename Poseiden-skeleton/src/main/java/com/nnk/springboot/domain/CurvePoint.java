package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CurvePoint extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Integer curveId;

    Timestamp asOfDate;

    Double term;

    @Column(name = "cp_value")
    Double value;

    Timestamp createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CurvePoint that = (CurvePoint) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
