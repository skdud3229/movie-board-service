package com.movieworld.movieboard.domain;

import java.time.LocalDateTime;

public class Board {
    private Long id;
    private String WriterName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private String content;
    private int views;
    private boolean isPrivate;

}
