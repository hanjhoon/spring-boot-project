package com.playdata.springbootproject.web;

import com.playdata.springbootproject.domain.hikers.Hikers;
import com.playdata.springbootproject.domain.hikers.SessionHikers;
import com.playdata.springbootproject.service.HikersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@CrossOrigin("*")
@Controller
public class SearchController {
    private Hikers hikers;
    private HikersService hikersService;
    @GetMapping("/id_search")
    public String idSearch(Model model, HttpSession httpSession){

        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "id-search";
    }
    @GetMapping("/pw_search")
    public String pwSearch(Model model, HttpSession httpSession){

        SessionHikers user = (SessionHikers) httpSession.getAttribute("userid");
        if(user!=null) {
            model.addAttribute("userid", user.getUserid());
        }
        return "pw-search";
    }

}
