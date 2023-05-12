package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String climbing_mountain;
    private Date climbing_date;
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .climbing_mountain(climbing_mountain)
                .climbing_date(climbing_date)
                .build();
    }
}
