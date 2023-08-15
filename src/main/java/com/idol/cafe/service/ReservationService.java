package com.idol.cafe.service;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.domain.entity.Reservation;
import com.idol.cafe.domain.entity.User;
import com.idol.cafe.dto.request.CafeReservationRequest;
import com.idol.cafe.dto.request.LoginUser;
import com.idol.cafe.exception.CafeNotFound;
import com.idol.cafe.exception.DuplicateReservationException;
import com.idol.cafe.exception.UserNotFound;
import com.idol.cafe.repository.CafeRepository;
import com.idol.cafe.repository.ReservationRepository;
import com.idol.cafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CafeRepository cafeRepository;
    private final UserRepository userRepository;

    @Transactional
    public void reservation(LoginUser loginUser, Long cafeId, CafeReservationRequest request) {
        User user = userRepository.findById(loginUser.getId())
                .orElseThrow(UserNotFound::new);

        Cafe cafe = cafeRepository.findById(cafeId)
                .orElseThrow(CafeNotFound::new);

        Boolean isReserved = reservationRepository.isReserved(cafeId, request);
        System.out.println("isReserved = " + isReserved);

        if (!isReserved) {
            throw new DuplicateReservationException();
        }

        Reservation reservation = Reservation.builder()
                .idol(request.getIdolName())
                .cafe(cafe)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isReserved(true)
                .user(user)
                .build();

        reservationRepository.save(reservation);
    }

}
