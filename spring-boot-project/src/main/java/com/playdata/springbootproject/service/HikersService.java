package com.playdata.springbootproject.service;

import com.playdata.springbootproject.domain.hikers.Hikers;
import com.playdata.springbootproject.domain.hikers.HikersRepository;
import com.playdata.springbootproject.domain.posts.Posts;
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
    public HikersResponseDto findById(Long id) {
        Hikers hikers =hikersRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 회원정보를 찾을 수 없습니다."));
        return new HikersResponseDto(hikers);
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
    public HikersResponseDto findByUserid(String userid) {
        Hikers hikers = hikersRepository.findByUserid(userid);
        return new HikersResponseDto(hikers);
    }
}
