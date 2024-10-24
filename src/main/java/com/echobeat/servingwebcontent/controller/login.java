package com.echobeat.servingwebcontent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ClientResponse;

// cookie
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class login {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/login")
    public String getSong(Model model, @RequestParam(name = "isInvalid", defaultValue = "false") String isInvalid) {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password,HttpServletResponse response) {
        ClientResponse resp = webClientBuilder.build()
                .post()
                .uri("http://localhost:8081/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password))
                .exchange()
                .block();
        if (resp != null && resp.statusCode().is2xxSuccessful()) {
            String token = resp.bodyToMono(new ParameterizedTypeReference<String>() {}).block();
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);

            return "redirect:/fyp";
        } else {
            return "redirect:/login?isInvalid=true";
        }
    }

    @GetMapping("/logout")
    public String deleteCookie(HttpServletResponse response) {

        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return "redirect:/login";
    }
}