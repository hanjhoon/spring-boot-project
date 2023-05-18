package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.hikers.Hikers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdSearchRequestDto {
    private String phone;
    private String ssn;

    public Hikers toEntity(){
        return Hikers.builder()
                .phone(phone)
                .ssn(ssn)
                .build();
    }
}
