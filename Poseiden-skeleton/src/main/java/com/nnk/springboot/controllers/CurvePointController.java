package com.nnk.springboot.controllers;

import com.nnk.springboot.controllers.api.CrudController;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/curvePoint")
public class CurvePointController extends CrudController<CurvePoint, CurvePointService> {

    public CurvePointController(CurvePointService service) {
        super(service);
    }

    @Override
    public String getModelIdentifier() {
        return "curvePoint";
    }
}
