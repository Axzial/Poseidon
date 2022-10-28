package com.nnk.springboot.domain;

import lombok.SneakyThrows;

public abstract class BaseEntity {

    public abstract Long getId();

    public abstract void setId(Long id);

}
