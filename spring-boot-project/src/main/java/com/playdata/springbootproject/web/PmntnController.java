package com.playdata.springbootproject.web;


import com.playdata.springbootproject.service.PmntnService;
import com.playdata.springbootproject.web.dto.PmntnResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PmntnController {
    private final PmntnService pmntnService;
    private final HttpSession httpSession;

    private int pageNum;

//    @GetMapping("/pmntn")
//    public String pmntn(Model model, @RequestParam(value = "pagenm", defaultValue = "0") String pagenm) {
//        pageNum = Integer.parseInt(pagenm);
//        model.addAttribute("page", pageNum+1);
//
//        // 데이터 20개씩 표현하기 위해 pageable 형성
//        Pageable pageable = PageRequest.of(pageNum, 20);
//        List<PmntnResponseDto> pmntnResponseDto = pmntnService.findAllBy(pageable);
//
//        //pageable 되어 있지 않은 총 데이터 개수 확인
//        List<PmntnResponseDto> pmntnResponseDtos = pmntnService.findAll();
//        int dataNum = pmntnResponseDtos.size();
//        System.out.println(dataNum);
//
//        model.addAttribute("dataNum", dataNum);
//        model.addAttribute("pmntn", pmntnResponseDto);
////        SessionUser user = (SessionUser) httpSession.getAttribute("user");
////
////        if(user != null){
////            model.addAttribute("userName", user.getName());
////        }
//        return "pmntn";
//
//    }

    @GetMapping("/pmntn")
    public String pmntnSearch(Model model,
                              @RequestParam(value = "pagenm", defaultValue = "0") String pagenm,
                              @RequestParam(value = "level", defaultValue = "#") String level,
                              @RequestParam(value = "time", defaultValue = "#") String time) {

        pageNum = Integer.parseInt(pagenm);
        model.addAttribute("page", pageNum+1);

        Pageable pageable = PageRequest.of(pageNum, 20);

        List<PmntnResponseDto> pmntnResponseDto = pmntnService.findAllBy(pageable);

        //총 개수 확인을 위한 데이터
        List<PmntnResponseDto> pmntnResponseDtos = pmntnService.findAll();

        // 둘 다 값이 있을 때
        if(!level.equals("#") && !time.equals("#")){
            switch (time) {
                case "0" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetweenAndLevel(0, 60, level, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetweenAndLevel(0, 60, level);
                }
                case "1" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetweenAndLevel(61, 120, level, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetweenAndLevel(61, 120, level);
                }
                case "2" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetweenAndLevel(121, 180, level, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetweenAndLevel(121, 180, level);
                }
                case "3" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetweenAndLevel(181, 240, level, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetweenAndLevel(181, 240, level);
                }
                case "4" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetweenAndLevel(241, 300, level, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetweenAndLevel(241, 300, level);
                }
                case "5" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetweenAndLevel(301, 360, level, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetweenAndLevel(301, 360, level);
                }
                case "6" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetweenAndLevel(361, 420, level, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetweenAndLevel(361, 420, level);
                }
                case "7" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetweenAndLevel(421, 3600, level, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetweenAndLevel(421, 3600, level);
                }
            }
            ;
        }

        // level은 유효값 time 전체 선택
        else if (!level.equals("#")) {
            pmntnResponseDto = pmntnService.findByPmntnDffl(level, pageable);
            pmntnResponseDtos = pmntnService.findByPmntnDffl(level);
        }

        // level 전체 선택 time은 유효값
        else if (!time.equals("#")) {
            switch (time) {
                case "0" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetween(0, 60, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetween(0, 60);
                }
                case "1" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetween(61, 120, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetween(61, 120);
                }
                case "2" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetween(121, 180, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetween(121, 180);
                }
                case "3" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetween(181, 240, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetween(181, 240);
                }
                case "4" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetween(241, 300, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetween(241, 300);
                }
                case "5" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetween(301, 360, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetween(301, 360);
                }
                case "6" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetween(361, 420, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetween(361, 420);
                }
                case "7" -> {
                    pmntnResponseDto = pmntnService.findByPmntnTmBetween(421, 3600, pageable);
                    pmntnResponseDtos = pmntnService.findByPmntnTmBetween(421, 3600);
                }
            }
        }
        int dataNum = pmntnResponseDtos.size();

        model.addAttribute("level", level);
        model.addAttribute("time", time);
        model.addAttribute("pmntnSearched", pmntnResponseDto);
        model.addAttribute("dataNum", dataNum);

        if (pageNum != 0){
            model.addAttribute("hasPreviousPage","y");
            model.addAttribute("previousPage",pageNum-1);
        }
        int maxPage = (dataNum / 20);
        model.addAttribute("maxPage", maxPage+1);
        if (pageNum != maxPage){
            model.addAttribute("hasNextPage","y");
            model.addAttribute("nextPage",pageNum+1);
        }


        level = null;
        time = null;
        dataNum = 0;
        return "pmntn";
    }


}
