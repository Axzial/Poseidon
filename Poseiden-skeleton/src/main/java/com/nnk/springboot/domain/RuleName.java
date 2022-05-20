package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "RuleName")
public class RuleName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String description;
    String json;
    String template;
    String sqlStr;
    String sqlPart;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RuleName ruleName = (RuleName) o;
        return id != null && Objects.equals(id, ruleName.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
