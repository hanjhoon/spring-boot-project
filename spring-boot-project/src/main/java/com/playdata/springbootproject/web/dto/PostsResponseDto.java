package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class PostsResponseDto {
    private String climbing_mountain;
    private Date climbing_date;
    private Long id;
    private String title;
    private String content;
    private String author;

    private LocalDateTime createdDate;

    public PostsResponseDto(Posts entity) {
        this.id=entity.getId();
        this.title= entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
        this.climbing_mountain=entity.getClimbing_mountain();
        this.climbing_date=entity.getClimbing_date();
        this.createdDate=entity.getCreatedDate();
    }
}
