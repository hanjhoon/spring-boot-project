package com.playdata.springbootproject.web.dto;
import lombok.Getter;
import com.playdata.springbootproject.domain.blogs.Blogs;

@Getter
public class BlogsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String hikerid;
    private String pmntnsn;
    public BlogsResponseDto(Blogs entity) {
        this.id=entity.getId();
        this.title= entity.getTitle();
        this.content=entity.getContent();
        this.hikerid=entity.getHikerid();
        this.pmntnsn=entity.getPmntnsn();
    }
}
