package com.movieworld.movieboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Node {
    @Id
    @NotNull
    @Column(name="ID")
    private String id;

    @ManyToOne
    @JoinColumn(name="Board_ID")
    private Board board;

    @Column(name="IS_HUB")
    private boolean isHub;

    @Column(name="PHOTOURL",length=500)
    private String PhotoUrl;

    @Column(name="AUTHORID",length=30)
    private String AuthorID;

    @Column(name="NAME",length=40)
    private String name;
    @Column(name="DETAILS",length=500)
    private String details;

/*    public Node(Board board, String id, boolean isHub, String photoUrl, String writer, String bob, String details){

    }*/

    public Node(@NotNull String id, Board board, boolean isHub, String photoUrl, String authorID, String name, String details) {
        this.id = id;
        this.board=board;
        this.isHub = isHub;
        this.PhotoUrl = photoUrl;
        this.AuthorID = authorID;
        this.name = name;
        this.details = details;
    }
}