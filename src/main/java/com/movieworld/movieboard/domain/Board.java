package com.movieworld.movieboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SequenceGenerator(
        name="BoardID_Sequence_Generator",
        sequenceName = "BoardID_Sequence",
        initialValue = 1,
        allocationSize = 1
)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "BoardID_Sequence")
    @NotNull
    @Column(name="ID")
    private Long id;

    @Column(name="WRITERNAME")
    private String WriterName;

    @Column(name="CREATEDAT")
    private LocalDateTime createdAt;

    @Column(name="UPDATEDAT")
    private LocalDateTime updatedAt;

    @Column(name="TITLE")
    private String title;

    @Column(name="CONTENT")
    private String content;

    @Column(name="VIEWS")
    private int views;

    @Column(name="ISPRIVATE")
    private boolean isPrivate;

    public Board(String title, String content, boolean isprivate) {
        this.title=title;
        this.content=content;
        this.isPrivate=isprivate;
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
        this.views=0;
    }
    public Board(){

    }
}
