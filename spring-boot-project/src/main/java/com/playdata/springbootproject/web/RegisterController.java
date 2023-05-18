package com.playdata.springbootproject.web;

import com.playdata.springbootproject.domain.hikers.SessionHikers;
import com.playdata.springbootproject.service.HikersService;
import com.playdata.springbootproject.web.dto.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class RegisterController {
    private final HikersService hikersService;
    @GetMapping("/api/v1/registers/{id}")
    public HikersResponseDto findById(@PathVariable Long id) {
        return hikersService.findById(id);
    }
    @PostMapping("/api/v1/registers")
    public Long save(@RequestBody HikersSaveRequestDto requestDto) {
        return hikersService.save(requestDto);
    }
    @PutMapping("/api/v1/registers/{id}")
    public Long update(@PathVariable Long id, @RequestBody HikersSaveRequestDto requestDto) {
        return hikersService.update(id,requestDto);
    }
    @DeleteMapping("/api/v1/registers/{id}")
    public Long delete(@PathVariable Long id) {
        hikersService.delete(id);
        return id;
    }
    @PostMapping("/api/v1/idSearch")
    public ResponseEntity<IdSearchResponseDto> idSearch(@RequestBody IdSearchRequestDto requestDto) {
        return new ResponseEntity<IdSearchResponseDto>(hikersService.findBySsnAndPhone(requestDto.getSsn(), requestDto.getPhone()),
                HttpStatus.OK);
    }

    @PostMapping("/api/v1/pwSearch")
    public ResponseEntity<PwSearchResponseDto> pwSearch(@RequestBody PwSearchRequestDto requestDto) {
        return new ResponseEntity<PwSearchResponseDto>(hikersService.findBySsnAndPhoneAndUserid(requestDto.getSsn(),requestDto.getUserid(), requestDto.getPhone()),
                HttpStatus.OK);
    }

}