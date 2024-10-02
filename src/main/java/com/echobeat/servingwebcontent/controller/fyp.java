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
        songname.add("nigga1");
        songname.add("nigga2");
        songname.add("nigga3");
        songname.add("nigga4");
        songname.add("nigga5");
        songname.add("nigga6");
        songname.add("nigga7");
        songname.add("nigga8");
        songname.add("nigga9");
        songname.add("nigga10");
        model.addAttribute("songs", songname);
        return "fyp";
    }
}