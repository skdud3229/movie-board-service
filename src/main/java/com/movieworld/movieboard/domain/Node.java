package com.movieworld.movieboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

@Entity
public class Node {
    @Id
    @NotNull
    @Column(name="ID")
    private String id;

    @Column(name="IsHub")
    private boolean isHub;

    @Column(name="PhotoUrl",length=500)
    private String PhotoUrl;

    @Column(name="AuthorID",length=30)
    private String AuthorID;

    @Column(name="Name",length=40)
    private String name;
    @Column(name="Details",length=500)
    private String details;
    //String author;
    public Node(String id, boolean isHub, String PhotoUrl, String name, String details){
        this.id=id;
        this.isHub=isHub;
        this.PhotoUrl=PhotoUrl;
        this.name=name;
        this.details=details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public boolean isHub() {
        return isHub;
    }

    public void setHub(boolean hub) {
        isHub = hub;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAuthorID() {return AuthorID;}

    public void setAuthorID(String authorID) {AuthorID = authorID;}

}