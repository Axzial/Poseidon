package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.BidListService;
import com.nnk.springboot.service.CurvePointService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curvePoint")
public class ApiCurvePointController extends ApiCrudController<CurvePoint, CurvePointService> {
    public ApiCurvePointController(CurvePointService service) {
        super(service);
    }
}
