package com.playdata.springbootproject.web;

import com.playdata.springbootproject.config.auth.SessionUser;
import com.playdata.springbootproject.domain.hikers.SessionHikers;
import com.playdata.springbootproject.service.BlogsService;
import com.playdata.springbootproject.service.HikersService;
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
@CrossOrigin("*")
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HikersService hikersService;
    private final BlogsService blogsService;
    @GetMapping("/")
    public String index(Model model, HttpSession httpSession, String userid){
//        //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
//        model.addAttribute("posts", postsService.findAllDesc());
//        model.addAttribute("hikers", hikersService.findByUserid(userid));
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "index";// src/main/resources/templetes/ + "index" + .mustache
    }
    @GetMapping("/news")
    public String news(Model model, HttpSession httpSession, String userid){
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "news";
    }
    @GetMapping("/blogs/save")
    public String saveBlog(){
        return "blog-save";
    }
    @GetMapping("/blogs/{id}")
    public String blogUpdate(Model model, @PathVariable Long id) {
        model.addAttribute("blog", blogsService.findById(id));
        return "blog-update";
    }
    @GetMapping("/blog")
    public String blog(Model model, HttpSession httpSession, @RequestParam(value="searchQuery", defaultValue = "") String userid){
        //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("blogs", blogsService.findByUserid(userid));
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "blog";
    }
    @GetMapping("/register")
    public String register(Model model, HttpSession httpSession) {
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "register";
    }
    @GetMapping("/log-in")
    public String logIn(Model model, HttpSession httpSession) {
        return "login";
    }
    @GetMapping("/log-out")
    public String logOut(Model model, HttpSession httpSession) {
        httpSession.invalidate();
        return "login";
    }
    @GetMapping("/search")
    public String search() {
        return "search";
    }
}

