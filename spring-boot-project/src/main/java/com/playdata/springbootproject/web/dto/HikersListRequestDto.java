package com.playdata.springbootproject.web.dto;

import com.playdata.springbootproject.domain.hikers.Hikers;
import lombok.Getter;

@Getter
public class HikersListRequestDto {
    private Long id;
    private String userid;
    private String PW;
    private String firstname;
    private String lastname;
    private String SSN;
    private Integer age;
    private String sex;
    private String phone;

    public HikersListRequestDto(Hikers hikers) {
        this.id = hikers.getId();
        this.userid=hikers.getUserid();
        this.PW = hikers.getPw();
        this.firstname = hikers.getFirstname();
        this.lastname = hikers.getLastname();
        this.SSN = hikers.getSsn();
        this.age = hikers.getAge();
        this.sex = hikers.getSex();
        this.phone = hikers.getPhone();
    }
}
