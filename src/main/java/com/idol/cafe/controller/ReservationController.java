package com.idol.cafe.controller;

import com.idol.cafe.config.Login;
import com.idol.cafe.dto.request.CafeReservationRequest;
import com.idol.cafe.dto.request.LoginUser;
import com.idol.cafe.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/{cafeId}/reservation")
    public void reservation(@Login LoginUser loginUser, @PathVariable Long cafeId, @RequestBody CafeReservationRequest request) {
        reservationService.reservation(loginUser, cafeId, request);
    }

}
