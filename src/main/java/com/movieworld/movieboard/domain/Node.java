package com.movieworld.movieboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Entity
@Getter
@Setter
public class Node {
    @Id
    @NotNull
    private String id;

    private boolean isHub;

    @Column(length=500)
    private String PhotoUrl;

    @Column(length=30)
    private String AuthorID;

    @Column(length=40)
    private String name;
    @Column(length=500)
    private String details;
    public Node(){

    }

    public Node(@NotNull String id, boolean isHub, String photoUrl, String authorID, String name, String details) {
        this.id = id;
        this.isHub = isHub;
        PhotoUrl = photoUrl;
        AuthorID = authorID;
        this.name = name;
        this.details = details;
    }


}