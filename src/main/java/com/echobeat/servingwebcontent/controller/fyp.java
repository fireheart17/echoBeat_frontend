package com.echobeat.servingwebcontent.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fyp {
    @GetMapping("/fyp")
    public String getSong(Model model) {
        List<String> songname = new ArrayList<>();
        songname.add("song1");
        songname.add("song2");
        songname.add("song3");
        songname.add("song4");
        songname.add("song5");
        songname.add("song6");
        songname.add("song7");
        songname.add("song8");
        songname.add("song9");
        songname.add("song10");
        model.addAttribute("songs", songname);
        return "fyp";
    }
}