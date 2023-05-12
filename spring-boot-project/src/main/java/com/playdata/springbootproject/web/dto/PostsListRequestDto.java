package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.posts.Posts;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class PostsListRequestDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime createdDate;
    private String climbing_mountain;
    private Date climbing_date;

    public PostsListRequestDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.createdDate = posts.getCreatedDate();
        this.climbing_mountain=posts.getClimbing_mountain();
        this.climbing_date=posts.getClimbing_date();
    }
}
