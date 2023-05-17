package com.playdata.springbootproject.domain.hikers;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class SessionHikers implements Serializable {
    private String userid;
    public SessionHikers(String userid) {
        this.userid = userid;
    }
}
