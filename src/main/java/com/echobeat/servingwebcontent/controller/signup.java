package com.echobeat.servingwebcontent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ClientResponse;


@Controller
public class signup {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/signup")
    public String getSong(Model model) {
        return "signup";
    }

    @PostMapping("/signup")
    public String loginUser(@RequestParam String username, @RequestParam String password,@RequestParam String first_name, @RequestParam String last_name,@RequestParam String dob,@RequestParam String gender,HttpServletResponse response) {
        ClientResponse resp = webClientBuilder.build()
                .post()
                .uri("http://localhost:8081/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(String.format("{\n" + //
                                        "    \"username\":\"%s\",\n" + //
                                        "    \"password\":\"%s\",\n" + //
                                        "    \"first_name\":\"%s\",\n" + //
                                        "    \"last_name\":\"%s\",\n" + //
                                        "    \"subscription_id\":0,\n" + //
                                        "    \"dob\":\"%s\",\n" + //
                                        "    \"gender\":\"%s\"\n" + //
                                        "}", username, password,first_name,last_name,dob,gender))
                .exchange()
                .block();
        if (resp != null && resp.statusCode().is2xxSuccessful()) {
            return "redirect:/login";
        } else {
            return "redirect:/signup?isInvalid=true";
        }
    }
}