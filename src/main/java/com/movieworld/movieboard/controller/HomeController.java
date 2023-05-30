package com.movieworld.movieboard.controller;

import com.movieworld.movieboard.DTO.BoardDTO;
import com.movieworld.movieboard.Service.BoardService;
import com.movieworld.movieboard.domain.Board;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final BoardService boardService;
    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    String Home(){
        return "mainpage";
    }
    @GetMapping("/newBoard")
    String newBoard(){
        return "newBoard";
    }
    @RequestMapping(value="/newBoard",method = RequestMethod.POST)
    String newBoard(@ModelAttribute BoardDTO boardDTO){
        boardService.AddBoard(boardDTO);
        return "redirect:/network";
    }

    @GetMapping("/Boards")
    String Boards(RedirectAttributes attributes){
        attributes.addAttribute("pagenum",1);
        return "redirect:/Boardlist";
    }

    @GetMapping("/Boardlist")
    String Boardlist(HttpServletRequest request, Model model){
        int pn= Integer.parseInt(request.getParameter("pagenum"));
        List boardlist=boardService.ReturnBoard(pn);
        model.addAttribute("boardlist",boardlist);
        model.addAttribute("pn",pn);
        return "Boardlist";
    }


}
