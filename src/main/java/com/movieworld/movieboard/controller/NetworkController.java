package com.movieworld.movieboard.controller;

import com.movieworld.movieboard.Service.NodeEditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.movieworld.movieboard.domain.Node;

import java.util.ArrayList;

@Controller
public class NetworkController {
    private final NodeEditService nodeEditService;

    public NetworkController(NodeEditService nodeEditService) {
        this.nodeEditService = nodeEditService;
    }

    @GetMapping("/network")
    String network(Model model){
        Node node1=new Node("0",1,false, "minions_bob.jpg","writer","bob","it's minions bob!");
        Node node2=new Node("1",1,false,null,"writer","second","this is second node");
        Node node3=new Node("2",1,false,null,"writer","third","this is third node");
        ArrayList<Node> nodes=new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        model.addAttribute("nodeList",nodes);
        return "network_sample";
    }
    @PostMapping("/network")
    String saveNetwork(@RequestBody ArrayList<NodeDTO> nodeList){
        for(NodeDTO element: nodeList){
            System.out.println(element.getType());
            System.out.println(element.getName());
            System.out.println(element.getDetails());
            nodeEditService.EditNode(nodeList);
        }
        return "redirect:/network";
    }
}
