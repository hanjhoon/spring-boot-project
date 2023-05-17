package com.playdata.springbootproject.web;

import com.playdata.springbootproject.config.auth.SessionUser;

import com.playdata.springbootproject.service.PostsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@Controller
public class FindController {
    private final PostsService postsService;
    @GetMapping("/finds")
    public String finds(Model model, HttpSession httpSession, @RequestParam(value="searchQuery", defaultValue = "") String climbing_mountain){
        //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsService.findByClimbingMountain(climbing_mountain));
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "find-climb";
    }
    @GetMapping("/finds/{climbing_mountain}")
    public String findsCllimbingMountain(Model model, HttpSession httpSession, @PathVariable String climbing_mountain){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "find-climb-search";
    }
    @GetMapping("/posts/save")
    public String savePost(Model model, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/{id}")
    public String postsUpdate(Model model, HttpSession httpSession, @PathVariable Long id) {
        model.addAttribute("post", postsService.findById(id));
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "posts-update";
    }

}
