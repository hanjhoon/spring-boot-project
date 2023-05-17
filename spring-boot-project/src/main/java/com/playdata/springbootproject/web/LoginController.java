package com.playdata.springbootproject.web;

import com.playdata.springbootproject.domain.hikers.SessionHikers;
import com.playdata.springbootproject.service.LoginService;
import com.playdata.springbootproject.web.dto.LoginRequestDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@SessionAttributes("userid")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/log-in")
    public ResponseEntity<?> processLogin(@RequestBody LoginRequestDto dto, Model model, HttpSession httpSession) {
        boolean loginSuccess = loginService.authenticate(dto.getUserid(), dto.getPw());

        if (loginSuccess) {
            httpSession.setAttribute("userid", new SessionHikers(dto.getUserid()));
            model.addAttribute("userid", true);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            model.addAttribute("error", "아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}

