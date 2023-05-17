package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.blogs.Blogs;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlogsListRequestDto {
    private Long id;
    private String title;
    private LocalDateTime createdDate;
    private String userid;
    private String pmntnsn;

    public BlogsListRequestDto(Blogs blogs) {
        this.id = blogs.getId();
        this.title = blogs.getTitle();
        this.createdDate = blogs.getCreatedDate();
        this.userid= blogs.getUserid();
        this.pmntnsn=blogs.getPmntnsn();
    }
}
