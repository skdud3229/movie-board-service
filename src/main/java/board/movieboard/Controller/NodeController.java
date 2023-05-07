package board.movieboard.Controller;

import board.movieboard.domain.Node;
import board.movieboard.Repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NodeController {
    @Autowired
    NodeRepository nodeRepository;

    @GetMapping("/AddNode")
    public String board() {return "AddNode";}

    @PostMapping("/NodeForm")
    public String write(Node node){
        node.setName(node.getName());
        nodeRepository.save(node);
        return "redirect:/";
    }
}
