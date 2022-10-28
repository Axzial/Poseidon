package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RatingService;
import com.nnk.springboot.service.RuleNameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ruleName")
public class ApiRuleNameController extends ApiCrudController<RuleName, RuleNameService> {
    public ApiRuleNameController(RuleNameService service) {
        super(service);
    }
}
