package com.springsecurity1.controller;

import com.springsecurity1.model.Users;
import com.springsecurity1.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final UserService service;

    public HomeController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(){
        return "Welcome to Home";
    }
    @GetMapping("/p")
    public String persolan(){
        return "Welcome to personal page";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Welcome to admin page";
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {

        return service.verify(user);
    }
}