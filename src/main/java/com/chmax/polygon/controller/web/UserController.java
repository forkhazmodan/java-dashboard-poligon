package com.chmax.polygon.controller.web;

import com.chmax.polygon.auth.Principal;
import com.chmax.polygon.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    UserService userServiceImpl;

    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String getUsers(@AuthenticationPrincipal Principal principal, Model model) {
        var users = userServiceImpl.getUsers();

        System.out.println(principal);
        System.out.println(model.getClass());
        model.addAttribute("users", users);
        return "users";
    }

}
