package com.playdata.springbootproject.web.dto;
import com.playdata.springbootproject.domain.blogs.Blogs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogsSaveRequestDto {
    private String title;
    private String content;
    private String hikerid;
    private String pmntnsn;
    public Blogs toEntity(){
        return Blogs.builder()
                .title(title)
                .content(content)
                .userid(hikerid)
                .pmntnsn(pmntnsn)
                .build();
    }
}
