package com.playdata.springbootproject.web;

import com.playdata.springbootproject.config.auth.SessionUser;

import com.playdata.springbootproject.service.PostsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@Controller
public class FindController {
    private final PostsService postsService;

    @GetMapping("/finds/{climbing_mountain}")
    public String finds(Model model, HttpSession httpSession, @PathVariable String climbing_mountain){
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

}
