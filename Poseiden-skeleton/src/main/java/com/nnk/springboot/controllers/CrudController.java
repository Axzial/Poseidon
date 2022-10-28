package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BaseEntity;
import com.nnk.springboot.service.CrudService;
import com.nnk.springboot.utils.IgnoreField;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
public abstract class CrudController<M extends BaseEntity, S extends CrudService<M, Long>> {

    private final S service;

    public abstract String getModelIdentifier();

    public Set<String> generateFields(M model) {
        return Arrays.stream(model.getClass().getDeclaredFields())
                .filter(field -> !field.isAnnotationPresent(IgnoreField.class))
                .map(Field::getName)
                .filter(f -> !f.equalsIgnoreCase("id"))
                .peek(log::info).collect(Collectors.toSet());
    }

    @SneakyThrows
    @GetMapping("/list")
    public String list(M list, Model model) {
        List<M> all = service.findAll();
        model.addAttribute("list", all);
        model.addAttribute("fields", generateFields(list));
        return "/list";
    }

    @SneakyThrows
    @GetMapping("/add")
    public String addForm(M add, Model model) {
        model.addAttribute("routerPath", getModelIdentifier());
        model.addAttribute("fields", generateFields(add));
        model.addAttribute("add", add.getClass().getDeclaredConstructor().newInstance());
        return "/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute(name = "add") M add, BindingResult result) {
        if (result.hasErrors()) {
            return "/add";
        }
        service.create(add);
        return "redirect:/" + getModelIdentifier() + "/list";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("routerPath", getModelIdentifier());
        M update = service.findById(id).orElseThrow();
        model.addAttribute("update", update);
        model.addAttribute("id", update.getId());
        model.addAttribute("fields", generateFields(update));
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("update") M update, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "/update";
        }
        service.update(update, id);
        return "redirect:/" + getModelIdentifier() + "/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        model.addAttribute("list", service.findAll());
        return "redirect:/" + getModelIdentifier() + "/list";
    }

}
