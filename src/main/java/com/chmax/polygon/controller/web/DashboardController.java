package com.chmax.polygon.controller.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/dashboard")
public class DashboardController {

    @GetMapping
    public String dashboard(Authentication authentication) {

        System.out.println(authentication);

        System.out.println("dashboard");
        return "dashboard";
    }
}
