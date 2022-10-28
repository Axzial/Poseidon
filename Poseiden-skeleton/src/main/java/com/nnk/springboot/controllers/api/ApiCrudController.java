package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.BaseEntity;
import com.nnk.springboot.service.CrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
public abstract class ApiCrudController<M extends BaseEntity, S extends CrudService<M, Long>> {

    private final S service;

    @GetMapping
    public List<M> get(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public M getOne(@PathVariable Long id){
        return service.findById(id).orElseThrow();
    }

    @PostMapping
    public M create(@RequestBody M create){
        return service.create(create);
    }

    @PatchMapping("/{id}")
    public M update(@PathVariable Long id, @RequestBody M update){
        return service.update(update, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
