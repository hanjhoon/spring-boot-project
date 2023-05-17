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
    public String MyPageByUserid(Model model, HttpSession httpSession, String userid){
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        model.addAttribute("hikers", hikersService.findByUserid(userid));
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "MyPage";
    }
    @GetMapping("/MyPage")
    public String MyPage(Model model, HttpSession httpSession, String userid) {
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "MyPage";
    }
    @GetMapping("/MyPage/Setting")
    public String MyPageSetting() {
        return "MyPage-Setting";
    }

    @GetMapping("/MyPage/QA")
    public String MyPageQA() {
        return "MyPage-QA";
    }

    @GetMapping("/MyPage/Delete")
    public String MyPageDelete() {
        return "MyPage-Delete";
    }

    @GetMapping("/MyPage/update")
    public String MyPageUpdate(Model model, HttpSession httpSession, Long id) {

        model.addAttribute("hiker", hikersService.findById(id));
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }return "MyPage-update";
    }
}
