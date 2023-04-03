package com.movieworld.movieboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NetworkController {
    @GetMapping("/network")
    String network(){
        return "network";
    }
}
