package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.hikers.Hikers;
import lombok.Getter;

@Getter
public class HikersResponseDto {
    private Long id;
    private String userid;
    private String pw;
    private String firstname;
    private String lastname;
    private String ssn;
    private Integer age;
    private String sex;
    private String phone;

    public HikersResponseDto(Hikers entity) {
        this.id=entity.getId();
        this.userid=entity.getUserid();
        this.pw=entity.getPw();
        this.firstname=entity.getFirstname();
        this.lastname=entity.getLastname();
        this.ssn=entity.getSsn();
        this.age=entity.getAge();
        this.sex=entity.getSex();
        this.phone=entity.getPhone();

    }
}
