package com.playdata.springbootproject.domain.hikers;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class SessionHikers implements Serializable {
    private String id;
    private String pw;
    public SessionHikers(Hikers hikers) {
        this.id = hikers.getId();
        this.pw = hikers.getPw();
    }
}
