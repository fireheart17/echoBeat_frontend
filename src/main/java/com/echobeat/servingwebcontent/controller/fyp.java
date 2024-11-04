package com.echobeat.servingwebcontent.controller;

import java.awt.PageAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// WebClient dependencies
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;

import reactor.core.publisher.Mono;

import java.util.*;

import org.springframework.web.bind.annotation.CookieValue;


@Controller
public class fyp {

    // to add WebClient
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/fyp")
    public String getSong(Model model,@CookieValue(value="token",defaultValue="") String token) {
        
        if(token.equals("")){
            return "redirect:/login";
        }

        // dummy api call
        // Map<String, String>[] response = webClientBuilder.build()
        //         .get()
        //         .uri("https://jsonplaceholder.typicode.com/posts")
        //         .retrieve()
        //         .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
        //         .block();

        // System.out.println("response : "+Arrays.toString(response));

        
        // AUTH HEADER
        // .header("Authorization","Bearer "+token)


        Map<String, String>[] topPicks = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/toppicks")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
                .block();

        // String resp = webClientBuilder.build()
        //         .post()
        //         .uri("http://localhost:8081/api/login")
        //         .contentType(MediaType.APPLICATION_JSON)
        //         .bodyValue(String.format("{\"username\":\"%s\",\"password\":\"%s\"}","dsnjsdnj","gunuoewgtnefg"))
        //         .retrieve()
        //         .bodyToMono(new ParameterizedTypeReference<String>() {})
        //         .block();
        
        // System.out.println("resp : "+resp);
        
        Map<String, String>[] newTracks = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/newtracks")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
                .block();

        model.addAttribute("topPicks", topPicks);
        model.addAttribute("newTracks", newTracks);
        return "fyp";
    }
}