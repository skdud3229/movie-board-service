package com.movieworld.movieboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NetworkController {
    @GetMapping("/network")
    String network(Model model){
        Node node1=new Node("0",false, "minions_bob.jpg","bob","it's minions bob!");
        Node node2=new Node("1",false,null,"second","this is second node");
        Node node3=new Node("2",false,null,"third","this is third node");
        List<Node> nodes=new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        model.addAttribute("nodeList",nodes);
        return "network_sample";
    }
    @PostMapping("/network")
    String saveNetwork(@RequestBody List<updatedNode> nodeList){
        for (updatedNode element : nodeList) {
            System.out.println(element.getType());
            System.out.println(element.getId());
            System.out.println(element.getName());
        }
        return "redirect:/network ";
    }
}
