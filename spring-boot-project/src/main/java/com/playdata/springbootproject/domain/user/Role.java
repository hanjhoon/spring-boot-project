package com.playdata.springbootproject.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    /**
     * Spring Security에서는 권한 코드에 항상 접두어 "ROLE_,"이 기본적으로 붙습니다.
     * 그래서 코드별 키 값을 ROLE_GUEST, ROLE_USER라고 설정할 것 입니다.
     */
    GUEST("ROLE_GUEST", "Guest"),
    USER("ROLE_USER", "User") ;

    private final String key;
    private final String title;
}
