package com.idol.cafe.controller;

import com.idol.cafe.config.Login;
import com.idol.cafe.dto.request.CafeSearchRequest;
import com.idol.cafe.dto.request.LoginUser;
import com.idol.cafe.dto.request.SaveCafeRequest;
import com.idol.cafe.dto.request.UpdateCafeRequest;
import com.idol.cafe.dto.response.CafeResponse;
import com.idol.cafe.dto.response.CafeSearchResponse;
import com.idol.cafe.service.CafeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    @PostMapping("/cafe/register")
    public Long saveCafe(@Login LoginUser loginUser, @ModelAttribute SaveCafeRequest request) {
        return cafeService.saveCafe(loginUser, request);
    }

    @PatchMapping("/cafe/{cafeId}/update")
    public void updateCafe(@PathVariable Long cafeId, @ModelAttribute UpdateCafeRequest request) {
        cafeService.updateCafe(cafeId, request);
    }

    @GetMapping("/cafes")
    public List<CafeSearchResponse> searchCafe(@RequestParam int page, @RequestBody @Valid CafeSearchRequest request) {
        return cafeService.searchCafe(page, request);
    }

    @GetMapping("/cafe/{cafeId}/details")
    public CafeResponse getCafeDetails(@PathVariable Long cafeId) {
        return cafeService.getCafeDetails(cafeId);
    }

}
