package com.movieworld.movieboard.DTO;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class updatedNode {
    private String id;
    private int type;

    private boolean isHub;

    private String PhotoUrl;

    private String AuthorID;

    private String name;

    private String details;
    public updatedNode(){

    }

}
