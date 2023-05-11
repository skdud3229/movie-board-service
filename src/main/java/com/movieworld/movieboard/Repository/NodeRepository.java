package com.movieworld.movieboard.Repository;

import com.movieworld.movieboard.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node,String> {

}
