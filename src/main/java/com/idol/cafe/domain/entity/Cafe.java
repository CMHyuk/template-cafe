package com.idol.cafe.domain.entity;

import com.idol.cafe.domain.Address;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Cafe {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cafe_id")
    private Long id;

    private Boolean isReservable;
    private String cafeName;
    private String introduction;

    @Embedded
    private Address address;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Cafe(Boolean isReservable, String cafeName, String introduction, Address address, User user) {
        this.isReservable = isReservable;
        this.cafeName = cafeName;
        this.introduction = introduction;
        this.address = address;
        this.user = user;
    }

}
