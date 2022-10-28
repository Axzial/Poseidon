package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.BaseEntity;
import com.nnk.springboot.service.CrudService;
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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
public abstract class CrudController<M extends BaseEntity, S extends CrudService<M, Long>> {

    private final S service;

    public abstract String getModelIdentifier();

    @RequestMapping("/list")
    public String list(Model model) {
        List<M> all = service.findAll();
        model.addAttribute("list", all);
        return getModelIdentifier() + "/list";
    }

    @SneakyThrows
    @GetMapping("/add")
    public String addForm(M add, Model model) {
        model.addAttribute("fields", Arrays.stream(add.getClass().getDeclaredFields())
                .map(Field::getName)
                .filter(f -> !f.equalsIgnoreCase("id"))
                .peek(log::info).collect(Collectors.toSet()));
        model.addAttribute("add", add.getClass().newInstance());
        return "/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute(name = "add") M add, BindingResult result) {
        if (!result.hasErrors()) {
            service.create(add);
            return "redirect:/" + getModelIdentifier() + "/list";
        }
        return "/add";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        M update = service.findById(id).orElseThrow();
        // TODO DTO
        model.addAttribute("update", update);
        return getModelIdentifier() + "/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("update") M update, BindingResult result) {
        if (result.hasErrors()) {
            log.info(result.getAllErrors());
            return getModelIdentifier() + "/update";
        }
        update.setId(id);
        service.update(update);
        return "redirect:/" + getModelIdentifier() + "/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        model.addAttribute("list", service.findAll());
        return "redirect:/" + getModelIdentifier() + "/list";
    }

}
