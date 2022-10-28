package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bidList")
public class BidListController extends CrudController<BidList, BidListService> {

    public BidListController(BidListService service) {
        super(service);
    }

    @Override
    public String getModelIdentifier() {
        return "bidList";
    }
}
