package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.hikers.Hikers;
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
public class PwSearchRequestDto {
    private String userid;
    private String phone;
    private String ssn;

    public Hikers toEntity(){
        return Hikers.builder()
                .userid(userid)
                .phone(phone)
                .ssn(ssn)
                .build();
    }
}
