package com.echobeat.servingwebcontent.controller;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.*;

@Controller
public class artist {

    @Autowired
    private WebClient.Builder webClientBuilder;

    // @GetMapping("/user")
    // public String getUser(@RequestParam(name="id", required=false, defaultValue="0") String name, Model model) {
    //     // int id = Integer.parseInt(name);
        
    //     User user = webClientBuilder.build()
    //             .get()
    //             .uri("http://localhost:8081/api/user/"+name)
    //             .retrieve()
    //             .bodyToMono(new ParameterizedTypeReference<User>() {})
    //             .block();

    //     // User user=new User(id, "Abhigyan", "Pandey", "password", LocalTime.now(), 21, "Male", 100, "23/10/2024");
    //     model.addAttribute("user", user);
    //     return "user";
    // }

    @GetMapping("/artist")
    public String getArtist(@RequestParam(name="id", required=false, defaultValue="1") String name, Model model) {

        Map<String,String> artist = webClientBuilder.build()
            .get()
            .uri("http://localhost:8081/api/artists/"+name)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String,String>>() {})
            .block();
        
        Map<String,String>[] tracks = webClientBuilder.build()
            .get()
            .uri("http://localhost:8081/api/artisttracks/"+name)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String,String>[]>() {})
            .block();
        
        System.out.println(Arrays.toString(tracks));

        Map<String,String>[] albums = webClientBuilder.build()
            .get()
            .uri("http://localhost:8081/api/artistalbums/"+name)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String,String>[]>() {})
            .block();

        System.out.println(Arrays.toString(albums));
        
        model.addAttribute("artist", artist);
        model.addAttribute("tracks", tracks);
        model.addAttribute("albums", albums);
        return "artist";
    }

}