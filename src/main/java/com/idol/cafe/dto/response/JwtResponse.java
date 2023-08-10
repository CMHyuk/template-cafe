package com.idol.cafe.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JwtResponse {
    private final String accessToken;
    private final String refreshToken;
}
