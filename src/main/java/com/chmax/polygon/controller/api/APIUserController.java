package com.chmax.polygon.controller.api;

import com.chmax.polygon.model.User;
import com.chmax.polygon.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class APIUserController {

    UserService userServiceImpl;

    public APIUserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public List<User> getUsers() {
        return userServiceImpl.getUsers();
    }
}
