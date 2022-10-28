package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.RuleNameService;
import com.nnk.springboot.service.TradeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trade")
public class ApiTradeController extends ApiCrudController<Trade, TradeService> {
    public ApiTradeController(TradeService service) {
        super(service);
    }
}
