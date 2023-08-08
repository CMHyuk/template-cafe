package com.idol.cafe.controller;

import com.idol.cafe.dto.response.ReissuedTokenResponse;
import com.idol.cafe.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final JwtService jwtService;

    @PostMapping("/reissue")
    public ReissuedTokenResponse reissueToken(@RequestHeader("refreshToken") String refreshToken) {
        String reissuedAccessToken = jwtService.reissueAccessToken(refreshToken);
        return new ReissuedTokenResponse(reissuedAccessToken);
    }

}
