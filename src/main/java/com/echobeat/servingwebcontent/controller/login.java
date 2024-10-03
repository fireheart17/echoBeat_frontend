package com.echobeat.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {
    @GetMapping("/login")
    public String getSong(Model model) {
        return "login";
    }
}