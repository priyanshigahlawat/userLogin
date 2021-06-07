package com.example.userLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PortalController {

    @GetMapping("/index")
    public String display(){
        return "index";
    }
}
