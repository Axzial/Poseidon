package com.nnk.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudService<E> {

    public abstract JpaRepository<E, Integer> getRepository();

    public E save(E e){
        return getRepository().save(e);
    };

    public Optional<E> findById(Integer id){
        return getRepository().findById(id);
    };

    public List<E> findAll(){
        return getRepository().findAll();
    }

    public void delete(Integer id){
        getRepository().deleteById(id);
    };
}
