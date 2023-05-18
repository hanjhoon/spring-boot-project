package com.playdata.springbootproject.web;

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
public class BlogController {
    private final PostsService postsService;
    private final HikersService hikersService;
    private final BlogsService blogsService;
    @GetMapping("/blog/{userid}")
    public String blogByUserid(Model model, HttpSession httpSession, @PathVariable String userid){
        //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.

        model.addAttribute("blog", blogsService.findByUserid(userid));
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "blog";
    }

    @GetMapping("/blog/save")
    public String saveBlog(Model model, HttpSession httpSession){
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "blog-save";
    }

    @GetMapping("/blogs/save")
    public String saveBlog(){
        return "blog-save";
    }
    @GetMapping("/blogs/{id}")
    public String blogUpdate(Model model, HttpSession httpSession, @PathVariable Long id) {
        model.addAttribute("blog", blogsService.findById(id));
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "blog-update";
    }
}
