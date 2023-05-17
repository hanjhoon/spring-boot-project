package com.playdata.springbootproject.web.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String userid;
    private String pw;
}
