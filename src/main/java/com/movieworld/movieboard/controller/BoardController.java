package com.movieworld.movieboard.controller;

import com.movieworld.movieboard.Service.BoardService;
import com.movieworld.movieboard.Service.NodeEditService;
import com.movieworld.movieboard.domain.Board;
import com.movieworld.movieboard.domain.Node;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {
    private final BoardService boardService;
    private final NodeEditService nodeEditService;

    public BoardController(BoardService boardService, NodeEditService nodeEditService) {
        this.boardService = boardService;
        this.nodeEditService = nodeEditService;
    }

    @GetMapping("board/{no}")
    String TitleClick(@PathVariable("no")Long no, Model model){
        //Optional<Board> board=boardService.FindById(no); //해당 게시글의 id찾기
        List<Node>nodes=nodeEditService.GetNode(no); //해당 게시글에 있었던 노드 전부 가져오기
        System.out.println("board/no is running...\n");
        System.out.println(no);
        for (Node node:nodes) {
            System.out.println(node.getName());
        }
        model.addAttribute("nodeList",nodes);
        model.addAttribute("BoardID",no);
        return "network_sample";
    }
}
