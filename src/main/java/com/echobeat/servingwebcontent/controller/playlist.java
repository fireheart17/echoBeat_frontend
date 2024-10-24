package com.echobeat.servingwebcontent.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class playlist {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/playlist")
    public String getUser(@RequestParam(name="id", required=false, defaultValue="0") String name, Model model)  {

        Map<String, String> title = webClientBuilder.build()
        .get()
        .uri("http://localhost:8081/api/playlists/"+name)
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
        .block();

        model.addAttribute("title", title);

        Map<String, String>[] response = webClientBuilder.build()
        .get()
        .uri("http://localhost:8081/api/playlistsTracks/playlist/"+name)
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
        .block();
        model.addAttribute("Playlistsongs", response);
        return "playlist";
    }
}