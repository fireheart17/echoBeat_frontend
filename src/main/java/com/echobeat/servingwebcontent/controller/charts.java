package com.echobeat.servingwebcontent.controller;

import java.util.*;
import com.echobeat.servingwebcontent.model.Chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class charts {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/charts")
    public String getChart(Model model) {

        Map<String, String>[] response = webClientBuilder.build()
        .get()
        .uri("http://localhost:8081/api/charts")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
        .block();
        model.addAttribute("charts", response);
        return "charts";

    }
}