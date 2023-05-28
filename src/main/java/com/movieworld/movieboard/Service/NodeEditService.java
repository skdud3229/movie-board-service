package com.movieworld.movieboard.Service;

import com.movieworld.movieboard.DTO.updatedNode;
import com.movieworld.movieboard.Repository.NodeRepository;
import com.movieworld.movieboard.controller.NodeDTO;
import com.movieworld.movieboard.domain.Node;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeEditService {
    private final NodeRepository nodeRepository;

    public NodeEditService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public void EditNode(List<NodeDTO> nodelist){
        for(int i=0; i<nodelist.size(); i++){
            NodeDTO curNode=nodelist.get(i);
            int type=curNode.getType();

            //add
            if(type==0){
                System.out.println(curNode.getId());
                System.out.println(curNode.isHub());
                System.out.println(curNode.getPhotoUrl());
                //System.out.println(curNode.getAuthorID());
                System.out.println(curNode.getName());
                System.out.println(curNode.getDetails());
                Node newNode=new Node(curNode.getId(), curNode.getBoardID(), curNode.isHub(),curNode.getPhotoUrl(),curNode.getAuthorID(),curNode.getName(),curNode.getDetails());
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
}
