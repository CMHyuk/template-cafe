package com.idol.cafe.repository;

import com.idol.cafe.dto.request.CafeReservationRequest;

public interface ReservationCustom {
    Boolean isReserved(Long cafeId, CafeReservationRequest request);
}
