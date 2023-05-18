package com.playdata.springbootproject.web;


import com.playdata.springbootproject.domain.hikers.SessionHikers;
import com.playdata.springbootproject.service.HikersService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@Controller
public class MyPageController {
    private final HikersService hikersService;
    @GetMapping("/MyPage/{userid}")
    public String MyPageByUserid(Model model, HttpSession httpSession, @PathVariable String userid) {
        // 로그인한 hiker 정보 가져오기
        model.addAttribute("hiker", hikersService.findByUserid(userid));
        // 세션 유지
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "MyPage";
    }
    @GetMapping("/MyPage/Setting/{userid}")
    public String MyPageSetting(Model model, HttpSession httpSession, @PathVariable String userid) {
        model.addAttribute("hiker", hikersService.findByUserid(userid));

        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());

        } return "MyPage-Setting";
    }

    @GetMapping("/MyPage/QA/{userid}")
    public String MyPageQA(Model model, HttpSession httpSession, @PathVariable String userid) {
        model.addAttribute("hiker", hikersService.findByUserid(userid));

        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());

        } return "MyPage-QA";
    }

    @GetMapping("/MyPage/Delete/{userid}")
    public String MyPageDelete(Model model, HttpSession httpSession, @PathVariable String userid) {
        model.addAttribute("hiker", hikersService.findByUserid(userid));

        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());

        } return "MyPage-Delete";
    }

    @GetMapping("/MyPage/Update/{userid}")
    public String MyPageUpdate(Model model, HttpSession httpSession, @PathVariable String userid) {
        model.addAttribute("hiker", hikersService.findByUserid(userid));

        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }return "MyPage-update";
    }
}
