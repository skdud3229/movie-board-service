package com.movieworld.movieboard.controller;

import com.movieworld.movieboard.DTO.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    String Home(){
        return "mainpage";
    }
    @GetMapping("/newBoard")
    String newBoard(){
        return "newBoard";
    }
    @PostMapping("/newBoard")
    @ResponseBody
    String newBoard(@RequestBody BoardDTO boardDTO){

    }
}
