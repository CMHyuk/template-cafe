package com.idol.cafe.repository;

import com.idol.cafe.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationCustom {
}
