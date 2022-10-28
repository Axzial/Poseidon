package com.nnk.springboot.controllers;

import com.nnk.springboot.controllers.api.CrudController;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
