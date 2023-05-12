package com.playdata.springbootproject.web;

import com.playdata.springbootproject.config.auth.SessionUser;
import com.playdata.springbootproject.service.BlogsService;
import com.playdata.springbootproject.service.PostsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@CrossOrigin
@Controller
public class IndexController {
    private final PostsService postsService;
    private final BlogsService blogsService;
    @GetMapping("/")
    public String index(Model model, HttpSession httpSession){

        //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";// src/main/resources/templetes/ + "index" + .mustache
    }


    @GetMapping("/posts/{id}")
    public String postsUpdate(Model model, HttpSession httpSession,@PathVariable Long id) {
        model.addAttribute("post", postsService.findById(id));
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "posts-update";
    }
    @GetMapping("/blogs/save")
    public String saveBlog(){
        return "blog-save";
    }

    @GetMapping("/news")
    public String news(Model model, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null) {
            model.addAttribute("userName", user.getName());
        }
        return "news";
    }

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
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
//    @GetMapping("/blog")
//    public String blog(Model model, HttpSession httpSession, @RequestParam(value="searchQuery", defaultValue = "") String hikerid){
//        //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
//        model.addAttribute("blogs", blogsService.findByHikerid(hikerid));
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        if(user!=null) {
//            model.addAttribute("userName", user.getName());
//        }
//        return "blog";
//    }
    @GetMapping("/register")
    public String register(Model model, HttpSession httpSession) {
        return "register";
    }

}

