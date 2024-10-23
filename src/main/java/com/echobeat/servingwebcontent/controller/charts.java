package com.echobeat.servingwebcontent.controller;

import java.util.List;
import com.echobeat.servingwebcontent.model.Chart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class charts {
    @GetMapping("/charts")
    public String getChart(Model model) {

        List<Chart> charts = List.of(
            new Chart(1, "Global"),
            new Chart(2, "Pop"),
            new Chart(3, "Rock")
        );
        model.addAttribute("charts", charts);
        return "charts";
    }
}