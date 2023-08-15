package com.idol.cafe.dto.response;

import com.idol.cafe.domain.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class CafeSearchResponse {
    private final String cafeName;
    private final Address address;
    private final String imageUrl;

    @Builder
    public CafeSearchResponse(String cafeName, Address address, String imageUrl) {
        this.cafeName = cafeName;
        this.address = address;
        this.imageUrl = imageUrl;
    }

}
