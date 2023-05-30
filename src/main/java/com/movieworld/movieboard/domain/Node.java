package com.movieworld.movieboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Entity
@Getter
@Setter
public class Node {
    @Id
    @NotNull
    @Column(name="ID")
    private String id;

    @Column(name="BOARDID")
    private int BoardID;

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

    public Node(){

    }

    public Node(@NotNull String id, int boardID,boolean isHub, String photoUrl, String authorID, String name, String details) {
        this.id = id;
        this.BoardID=boardID;
        this.isHub = isHub;
        PhotoUrl = photoUrl;
        AuthorID = authorID;
        this.name = name;
        this.details = details;
    }
}