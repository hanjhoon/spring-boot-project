package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListRequestDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime createdDate;

    public PostsListRequestDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.createdDate = posts.getCreatedDate();

    }
}
