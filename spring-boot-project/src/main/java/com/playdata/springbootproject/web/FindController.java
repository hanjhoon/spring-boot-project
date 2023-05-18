package com.playdata.springbootproject.web;

import com.playdata.springbootproject.config.auth.SessionUser;

import com.playdata.springbootproject.domain.hikers.SessionHikers;
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
    public String finds(Model model, HttpSession httpSession, @RequestParam(value="searchQuery", defaultValue = "") String climbing_mountain, String userid){
        model.addAttribute("posts", postsService.findByClimbingMountain(climbing_mountain));


        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "find-climb";
    }
    @GetMapping("/finds/{climbing_mountain}")
    public String findsClimbingMountain(Model model, HttpSession httpSession, @PathVariable String climbing_mountain){
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "find-climb-search";
    }
    @GetMapping("/posts/save")
    public String savePost(Model model, HttpSession httpSession){
        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "posts-save";
    }

    @GetMapping("/posts/{id}")
    public String postsUpdate(Model model, HttpSession httpSession, @PathVariable Long id) {
        model.addAttribute("post", postsService.findById(id));


        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "posts-update";
    }

}
