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
    public Object findByUserid(String userid) {
        return userid;
    }

//    public Hikers findBySsnAndPhone(String ssn, String phone) {
//        List<Hikers> hikers = hikersRepository.findBySsnAndPhone(ssn, phone);
//        if (!hikers.isEmpty()) {
//            return hikers.get(0);
//        }
//        return null;
//    }

}
