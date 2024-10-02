package com.echobeat.servingwebcontent.controller;

import java.time.LocalTime;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

class User {
    public long userId;
    public String firstName;
    public String lastName;
    public String password;
    public LocalTime dob;
    public int age;
    public String gender;
    public long  subscriptionId;
    public String subscriptionEndDate;

    User(long userId, String firstName, String lastName, String password, LocalTime dob, int age, String geder, long subscriptionId, String subscriptionEndDate){
        this.userId=userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.dob=dob;   
        this.age=age;
        this.subscriptionEndDate=subscriptionEndDate;
        this.subscriptionId=subscriptionId;
    }
}

@Controller
public class user {
    @GetMapping("/user")
    public String getUser(@RequestParam(name="id", required=false, defaultValue="0") String name, Model model) {
        int id = Integer.parseInt(name);
        User user=new User(id, "Abhigyan", "Pandey", "password", LocalTime.now(), 21, "Male", 100, "23/10/2024");
        model.addAttribute("user", user);
        return "user";
    }
}