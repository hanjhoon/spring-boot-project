package com.playdata.springbootproject.service;

import com.playdata.springbootproject.domain.hikers.Hikers;
import com.playdata.springbootproject.domain.hikers.HikersRepository;
import com.playdata.springbootproject.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HikersService {
    private final HikersRepository hikersRepository;
    public Long save(HikersSaveRequestDto requestDto) {

        return hikersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional // 두 개의 작업이 동시에 일어나야 한다
    public Long update(Long id, HikersSaveRequestDto requestDto) {
        Hikers hikers = hikersRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 등산객을 찾을 수 없습니다. id=" +id));
        hikers.update(requestDto.getPw(), requestDto.getFirstname(), requestDto.getLastname(),  requestDto.getAge(), requestDto.getSex(), requestDto.getPhone());
        return id;
    }
    @Transactional(readOnly = true)
    public List<HikersResponseDto> findAllDesc() {
        return hikersRepository.findAllDesc().stream()
                .map(HikersResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public Long delete(Long id) {
        Hikers hikers = hikersRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("오류."));
        hikersRepository.delete(hikers);
        return id;
    }
    public HikersResponseDto findById(Long id) {
        Hikers hikers =hikersRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" +id));
        return new HikersResponseDto(hikers);
    }

    public HikersResponseDto findByUserid(String userid) {
        Hikers hiker = hikersRepository.findByUserid(userid);
        if (hiker == null) {
            throw new IllegalArgumentException("userid=" + userid + " / 해당 회원정보를 찾을 수 없습니다.");
        }

        return new HikersResponseDto(hiker);
    }

    public IdSearchResponseDto findBySsnAndPhone(String ssn, String phone) {
        Hikers hiker = hikersRepository.findBySsnAndPhone(ssn, phone);
        if (hiker == null) {
            throw new IllegalArgumentException("아이디 찾기 / 해당 회원정보를 찾을 수 없습니다.");
        } else {
            System.out.println("아이디는 " + hiker.getUserid() + " 입니다");
        }
        return IdSearchResponseDto.builder().userid(hiker.getUserid()).build();
    }


    public PwSearchResponseDto findBySsnAndPhoneAndUserid(String ssn, String phone, String userid) {
        Hikers hiker = hikersRepository.findBySsnAndPhoneAndUserid(ssn, phone, userid);
        if (hiker == null) {
            throw new IllegalArgumentException("비밀번호 찾기 / 해당 회원정보를 찾을 수 없습니다.");
        }
        return PwSearchResponseDto.builder().pw(hiker.getPw()).build();
    }

}
