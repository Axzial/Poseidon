package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends CrudController<User, UserService> {

    public UserController(UserService service) {
        super(service);
    }

    @Override
    public String getModelIdentifier() {
        return "user";
    }

}
