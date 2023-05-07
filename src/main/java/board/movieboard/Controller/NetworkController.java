package board.movieboard.Controller;

import board.movieboard.domain.Node;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(nodes);
        return "network_sample";
    }

    //서버가 받은 리스트를 확인해야
    @PostMapping("/network")
    String saveNetwork(@RequestBody String nodeList){
        System.out.println(nodeList);
        return "redirect:/network";
    }
}