package com.idol.cafe.dto.response;

import com.idol.cafe.domain.Address;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CafeSearchResponse {
    private final String cafeName;
    private final Address address;
}
