package com.playdata.springbootproject.service;

import com.playdata.springbootproject.domain.pmntn.Pmntn;
import com.playdata.springbootproject.domain.pmntn.PmntnRepository;
import com.playdata.springbootproject.web.dto.PmntnResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PmntnService {
    private final PmntnRepository pmntnRepository;

    @Transactional
    public PmntnResponseDto findById(Integer pmntn_sn){
        Pmntn pmntn = pmntnRepository.findById(pmntn_sn)
                .orElseThrow(() -> new IllegalArgumentException("해당 등산로를 찾을 수 없습니다."));

        return new PmntnResponseDto(pmntn);
    }

    @Transactional(readOnly = true)
    public List<PmntnResponseDto> findAll() {
        return pmntnRepository.findAll().stream()
                .map(PmntnResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PmntnResponseDto> findAllBy(Pageable pageable) {
        return pmntnRepository.findAllBy(pageable).stream()
                .map(PmntnResponseDto::new)
                .collect(Collectors.toList());
    }

    // 소요시간 필터링 between
    public List<PmntnResponseDto> findByPmntnTmBetween(int minTime, int maxTime, Pageable pageable){
        return pmntnRepository.findByPmntnTmBetween(minTime, maxTime, pageable).stream()
                .map(PmntnResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<PmntnResponseDto> findByPmntnTmBetween(int minTime, int maxTime){
        return pmntnRepository.findByPmntnTmBetween(minTime, maxTime).stream()
                .map(PmntnResponseDto::new)
                .collect(Collectors.toList());
    }

    // 소요시간 between & level 필터링
    public List<PmntnResponseDto> findByPmntnTmBetweenAndLevel(Integer minTime, Integer maxTime, String pmntnDffl, Pageable pageable) {
        List<Pmntn> pmntn = pmntnRepository.findByPmntnTmBetweenAndLevel(minTime,  maxTime, pmntnDffl, pageable);
        return pmntn.stream()
                .map(PmntnResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<PmntnResponseDto> findByPmntnTmBetweenAndLevel(Integer minTime, Integer maxTime, String pmntnDffl) {
        List<Pmntn> pmntn = pmntnRepository.findByPmntnTmBetweenAndLevel(minTime,  maxTime, pmntnDffl);
        return pmntn.stream()
                .map(PmntnResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<PmntnResponseDto> findByPmntnDffl(String pmntnDffl, Pageable pageable){
        return pmntnRepository.findByPmntnDffl(pmntnDffl, pageable).stream()
                .map(PmntnResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<PmntnResponseDto> findByPmntnDffl(String pmntnDffl){
        return pmntnRepository.findByPmntnDffl(pmntnDffl).stream()
                .map(PmntnResponseDto::new)
                .collect(Collectors.toList());
    }
}
