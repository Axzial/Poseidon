package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
