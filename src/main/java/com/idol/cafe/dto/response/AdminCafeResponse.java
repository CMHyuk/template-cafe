package com.idol.cafe.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AdminCafeResponse {

    private final Long cafeId;
    private final String cafeName;
    private final String nickname;
    private final LocalDateTime localDateTime;

    @Builder
    public AdminCafeResponse(Long cafeId, String cafeName, String nickname, LocalDateTime localDateTime) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.nickname = nickname;
        this.localDateTime = localDateTime;
    }

}
