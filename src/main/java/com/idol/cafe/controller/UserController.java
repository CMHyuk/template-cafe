package com.idol.cafe.controller;

import com.idol.cafe.config.Login;
import com.idol.cafe.dto.request.LoginUser;
import com.idol.cafe.dto.response.JwtResponse;
import com.idol.cafe.dto.response.kakao.GetMemberInfoResponse;
import com.idol.cafe.service.JwtService;
import com.idol.cafe.service.KakaoLoginService;
import com.idol.cafe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final KakaoLoginService kakaoLoginService;
    private final JwtService jwtService;
    private final UserService userService;

    @PostMapping("/token")
    public JwtResponse kakaoLogin(@RequestParam String accessToken) {
        GetMemberInfoResponse userInfo = kakaoLoginService.getKakaoMemberInfo(accessToken);
        Long userId = userService.saveFromKakao(userInfo);

        String generateAccessToken = jwtService.generateAccessToken(userId);
        String generateRefreshToken = jwtService.generateRefreshToken(userId);

        return new JwtResponse(generateAccessToken, generateRefreshToken);
    }

    @PatchMapping("/updateRoleType")
    public void updateRoleType(@Login LoginUser loginUser, @RequestParam String roleType) {
        userService.updateRoleType(loginUser, roleType);
    }

}
