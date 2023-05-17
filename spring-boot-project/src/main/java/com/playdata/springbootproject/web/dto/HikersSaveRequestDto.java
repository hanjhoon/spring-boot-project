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
public class HikersSaveRequestDto {
    private String userid;
    private String pw;
    private String firstname;
    private String lastname;
    private String ssn;
    private Integer age;
    private String sex;
    private String phone;
    public Hikers toEntity(){
        return Hikers.builder()
                .userid(userid)
                .pw(pw)
                .firstname(firstname)
                .lastname(lastname)
                .ssn(ssn)
                .age(age)
                .sex(sex)
                .phone(phone)
                .build();
    }
}
