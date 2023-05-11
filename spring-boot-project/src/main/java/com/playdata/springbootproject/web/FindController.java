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

@RequiredArgsConstructor
@CrossOrigin
@Controller
public class FindController {
    private final PostsService postsService;

    @GetMapping("/finds/{climbing_mountain}")
    public String finds(Model model, HttpSession httpSession, @PathVariable String climbing_mountain){

        return "find-climb-search";
    }

}
