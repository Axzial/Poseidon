package com.nnk.springboot.controllers;

import com.nnk.springboot.controllers.api.CrudController;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/ruleName")
public class RuleNameController extends CrudController<RuleName, RuleNameService> {

    public RuleNameController(RuleNameService service) {
        super(service);
    }

    @Override
    public String getModelIdentifier() {
        return "ruleName";
    }
}
