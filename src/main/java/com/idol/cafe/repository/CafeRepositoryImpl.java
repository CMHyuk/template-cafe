package com.idol.cafe.repository;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.domain.entity.QCafe;
import com.idol.cafe.domain.entity.QReservation;
import com.idol.cafe.domain.entity.QUser;
import com.idol.cafe.dto.request.SearchRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CafeRepositoryImpl implements CafeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Cafe> getResults(SearchRequest request) {
        QCafe cafe = QCafe.cafe;
        QUser user = QUser.user;
        QReservation reservation = QReservation.reservation;

        BooleanBuilder predicate = new BooleanBuilder();

        if (request.getIdolName() != null) {
            predicate.and(cafe.cafeName.eq(request.getIdolName()));
        }

        if (request.getStartDate() != null && request.getEndDate() != null) {
            predicate.and(reservation.startDate.between(request.getStartDate(), request.getEndDate())
                    .or(reservation.endDate.between(request.getStartDate(), request.getEndDate())));
        }

        if (request.getPlace() != null) {
            predicate.and(cafe.address.area.eq(request.getPlace()));
        }

        if (request.getIdolName() != null && request.getStartDate() != null && request.getEndDate() != null && request.getPlace() != null) {
            predicate.and(cafe.cafeName.eq(request.getIdolName())
                    .and(reservation.startDate.between(request.getStartDate(), request.getEndDate())
                            .or(reservation.endDate.between(request.getStartDate(), request.getEndDate())))
                    .and(cafe.address.area.eq(request.getPlace())));
        }

        return queryFactory
                .selectFrom(cafe)
                .leftJoin(cafe.user, user)
                .leftJoin(cafe.reservations, reservation)
                .where(predicate)
                .fetch();
    }

}
