package com.idol.cafe.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReissuedTokenResponse {
    private final String accessToken;
}
