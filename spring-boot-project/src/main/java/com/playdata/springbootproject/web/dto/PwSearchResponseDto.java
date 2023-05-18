package com.playdata.springbootproject.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class PwSearchResponseDto {
    private String pw;
}
