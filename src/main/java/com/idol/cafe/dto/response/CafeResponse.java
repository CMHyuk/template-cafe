package com.idol.cafe.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CafeResponse {

    private final String cafeName;
    private final String introduction;
    private final String imageUrl;

    @Builder
    public CafeResponse(String cafeName, String introduction, String imageUrl) {
        this.cafeName = cafeName;
        this.introduction = introduction;
        this.imageUrl = imageUrl;
    }

}
