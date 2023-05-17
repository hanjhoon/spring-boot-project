package com.playdata.springbootproject.web;

import com.playdata.springbootproject.service.HikersService;
import com.playdata.springbootproject.web.dto.HikersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class RegisterController {
    private final HikersService hikersService;
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
}