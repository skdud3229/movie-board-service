package com.movieworld.movieboard.Service;

import com.movieworld.movieboard.DTO.BoardDTO;
import com.movieworld.movieboard.Repository.BoardRepository;
import com.movieworld.movieboard.domain.Board;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    public void AddBoard(BoardDTO boardDTO){
        System.out.println("board service is running...\n");
        System.out.println(boardDTO.getTitle());
        boolean isprivate;
        if(boardDTO.getIsPrivate()=="yes") isprivate=true;
        else isprivate=false;
        Board board = new Board(boardDTO.getTitle(),boardDTO.getContent(),isprivate);
        boardRepository.save(board);
    }

    public List<Board> ReturnBoard(int pn){
        List<Board>boardlist=boardRepository.findAll();
        List<Board>returnList=new ArrayList<Board>();
        int size= boardlist.size();
        if(size>5*pn) size=5*pn;
        for(int i=(pn-1)*5; i<size; i++) returnList.add(boardlist.get(i));
        return returnList;
    }

}
