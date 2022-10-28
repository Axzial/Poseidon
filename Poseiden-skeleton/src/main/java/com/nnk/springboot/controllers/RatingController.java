package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rating")
public class RatingController extends CrudController<Rating, RatingService> {

    public RatingController(RatingService service) {
        super(service);
    }

    @Override
    public String getModelIdentifier() {
        return "/rating";
    }
}
