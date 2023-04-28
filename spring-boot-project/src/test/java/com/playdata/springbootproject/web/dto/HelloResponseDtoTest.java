package com.playdata.springbootproject.web.dto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        // given
        String name ="George Kur";
        int amount = 100000000;

        // when
        // @RequiredArgsConstructor가 정말 필요한 필드에 대해서 생성자를 생성하는지 확인
        HelloResponseDto dto = new HelloResponseDto(name, amount);


        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}