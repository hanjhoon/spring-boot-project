package com.playdata.springbootproject.service;

import com.playdata.springbootproject.domain.hikers.Hikers;
import com.playdata.springbootproject.domain.hikers.HikersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private HikersRepository hikersRepository;
    public boolean authenticate(String userid, String pw) {
        Hikers hikers = hikersRepository.findByUserid(userid);
        if (hikers != null) {
            if (hikers.getPw().equals(pw)) {
                return true;
            }
        }
        return false;
    }
}
