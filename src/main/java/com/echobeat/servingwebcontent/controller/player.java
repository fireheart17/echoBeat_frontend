package com.echobeat.servingwebcontent.controller;

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

import reactor.core.publisher.Mono;

import java.net.http.HttpHeaders;
import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class player {

    // to add WebClient
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/player/{track_id}")
    public String getSong(Model model,@PathVariable("track_id") long track_id) {

        // dummy api call
        // Map<String, String>[] response = webClientBuilder.build()
        //         .get()
        //         .uri("https://jsonplaceholder.typicode.com/posts")
        //         .retrieve()
        //         .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
        //         .block();

        // System.out.println("response : "+Arrays.toString(response));

        Map<String, String>[] topPicks = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/toppicks")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
                .block();
        Map<String, String>[] newTracks = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/newtracks")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
                .block();

        model.addAttribute("topPicks", topPicks);
        model.addAttribute("newTracks", newTracks);
        // System.out.println("response : "+Arrays.toString(response));

        // Map<String, String> response = webClientBuilder.build()
        //         .get()
        //         .uri("https://jsonplaceholder.typicode.com/posts")
        //         .retrieve()
        //         .bodyToMono(new ParameterizedTypeReference<Map<String, String>[]>() {})
        //         .block();

        // System.out.println("response : "+response);

        // POST REQUEST
        // webClientBuilder.build()
        //         .post()
        //         .uri(url)
        //         .header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken) // Set the Authorization header
        //         .contentType(MediaType.APPLICATION_JSON) // Set the Content-Type to JSON
        //         .bodyValue(requestBody) // Set the body
        //         .retrieve()
        //         .bodyToMono(Map.class); 

        // songname.add("song1");
        // songname.add("song2");
        // songname.add("song3");
        // songname.add("song4");
        // songname.add("song5");
        // songname.add("song6");
        // songname.add("song7");
        // songname.add("song8");
        // songname.add("song9");
        // songname.add("song10");
        // // songname.add(response.get("track_name"));
        // model.addAttribute("songs", songname);
        return "fyp";
    }
}