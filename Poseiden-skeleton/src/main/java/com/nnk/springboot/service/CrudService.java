package com.nnk.springboot.service;

import com.nnk.springboot.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudService<E extends BaseEntity, I extends Long> {

    public abstract JpaRepository<E, I> getRepository();

    public E create(E e) {
        return getRepository().save(e);
    }

    public E update(E e, I id) {
        e.setId(id);
        return getRepository().save(e);
    }

    public Optional<E> findById(I id) {
        return getRepository().findById(id);
    }

    public List<E> findAll() {
        return getRepository().findAll();
    }

    public void delete(I id) {
        getRepository().deleteById(id);
    }
}
