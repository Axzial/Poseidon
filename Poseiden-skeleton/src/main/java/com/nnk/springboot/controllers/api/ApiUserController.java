package com.nnk.springboot.controllers.api;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ApiUserController extends ApiCrudController<User, UserService> {
    public ApiUserController(UserService service) {
        super(service);
    }
}
