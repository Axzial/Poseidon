package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.CurvePointService;
import com.nnk.springboot.service.RatingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rating")
public class ApiRatingController extends ApiCrudController<Rating, RatingService> {
    public ApiRatingController(RatingService service) {
        super(service);
    }
}
