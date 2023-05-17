package com.playdata.springbootproject.web;

import com.playdata.springbootproject.domain.hikers.Hikers;
import com.playdata.springbootproject.domain.hikers.HikersRepository;
import com.playdata.springbootproject.domain.hikers.SessionHikers;
import com.playdata.springbootproject.service.HikersService;
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
@CrossOrigin("*")
public class LoginController {
    private HikersService hikersService;
    @Autowired
    private LoginService loginService;
    @PostMapping("/log-in")
    public ResponseEntity<?> processLogin(@RequestBody LoginRequestDto dto, Model model, HttpSession httpSession) {
        boolean loginSuccess = loginService.authenticate(dto.getUserid(), dto.getPw());

        if (loginSuccess) {
            httpSession.setAttribute("userid", new SessionHikers(dto.getUserid()));
            model.addAttribute("userid", new SessionHikers(dto.getUserid()));
            httpSession.setMaxInactiveInterval(60 * 30);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            model.addAttribute("error", "아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

//    @GetMapping("/findUserid")
//    public String findUserid(@RequestParam("ssn") String ssn, @RequestParam("phone") String phone, Model model) {
//        Hikers hiker = hikersService.findBySsnAndPhone(ssn, phone);
//        if (hiker != null) {
//            model.addAttribute("userid", hiker.getUserid());
//        } else {
//            model.addAttribute("userid", "사용자를 찾을 수 없음");
//        }
//        return "findUserIdResult";
//    }


//    @GetMapping("/log-out")
//    public ResponseEntity<?> logout(HttpSession httpSession) {
//        httpSession.invalidate();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
