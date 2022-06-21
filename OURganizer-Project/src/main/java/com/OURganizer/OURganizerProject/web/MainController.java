package com.OURganizer.OURganizerProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/credentials")
    public String credentials() {
        return "credentials";
    }
    
    @GetMapping("/websites")
    public String websites() {
        return "websites";
    }
}