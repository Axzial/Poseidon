package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trade")
public class TradeController extends CrudController<Trade, TradeService> {

    public TradeController(TradeService service) {
        super(service);
    }

    @Override
    public String getModelIdentifier() {
        return "trade";
    }
}
