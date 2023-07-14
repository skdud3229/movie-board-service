package com.movieworld.movieboard.Service;

import com.movieworld.movieboard.Repository.BoardRepository;
import com.movieworld.movieboard.Repository.NodeRepository;
import com.movieworld.movieboard.controller.NodeDTO;
import com.movieworld.movieboard.domain.Board;
import com.movieworld.movieboard.domain.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NodeEditService {
    private final NodeRepository nodeRepository;
    private final BoardRepository boardRepository;

    public NodeEditService(NodeRepository nodeRepository, BoardRepository boardRepository) {
        this.nodeRepository = nodeRepository;
        this.boardRepository = boardRepository;
    }

    public void EditNode(List<NodeDTO> nodelist, Long BoardID) throws Exception {
        for(int i=0; i<nodelist.size(); i++){
            NodeDTO curNode=nodelist.get(i);
            int type=curNode.getType();

            //add
            if(type==0){
                System.out.println("curNode ID\n");
                System.out.println(curNode.getId());
                System.out.println(curNode.isHub());
                System.out.println(curNode.getPhotoUrl());
                //System.out.println(curNode.getAuthorID());
                System.out.println(curNode.getName());
                System.out.println(curNode.getDetails());
                Board board=boardRepository.findById(BoardID).orElseThrow(()->new Exception());
                System.out.println("find board : "); System.out.println(board.getId());
                Node newNode=new Node(curNode.getId(), board, curNode.isHub(),curNode.getPhotoUrl(),curNode.getAuthorID(),curNode.getName(),curNode.getDetails());
                System.out.println(newNode.getId());
                nodeRepository.save(newNode);
            }
            //delete
            else if(type==1){
                Node delNode=nodeRepository.findById(curNode.getId()).orElseThrow(()->new IllegalStateException("존재하지 않는 노드"));
                nodeRepository.delete(delNode);
            }
            //update
            else if(nodelist.get(i).getType()==2){
                Node updateNode=nodeRepository.findById(curNode.getId()).orElseThrow(()->new IllegalStateException("존재하지 않는 노드"));
                updateNode.setHub(curNode.isHub());
                updateNode.setPhotoUrl(curNode.getPhotoUrl());
                updateNode.setAuthorID(curNode.getAuthorID());
                updateNode.setName(curNode.getName());
                updateNode.setDetails(curNode.getDetails());
                //똑같이 save를 호출해도 내부적으로 업데이트로 처리해줌.
                nodeRepository.save(updateNode);
            }
        }
    }

    public ArrayList<Node> GetNode(Long BoardID){
        ArrayList<Node>nodelist= (ArrayList<Node>) nodeRepository.findByboard(BoardID);
        System.out.println("node edit service is running...\n");
        for (Node node:nodelist) {
            System.out.println(node.getId());
        }
        return nodelist;
    }
}
