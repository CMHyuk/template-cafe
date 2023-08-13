package com.idol.cafe.controller;

import com.idol.cafe.config.Login;
import com.idol.cafe.dto.request.LoginUser;
import com.idol.cafe.dto.request.SaveCafeRequest;
import com.idol.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    @PostMapping("/registerCafe")
    public Long saveCafe(@Login LoginUser loginUser, @RequestBody SaveCafeRequest request) {
        return cafeService.saveCafe(loginUser, request);
    }

}
