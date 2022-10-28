package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.BidListService;
import com.nnk.springboot.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bidList")
public class ApiBidListController extends ApiCrudController<BidList, BidListService> {
    public ApiBidListController(BidListService service) {
        super(service);
    }
}
