package com.idol.cafe.domain.entity;

import com.idol.cafe.domain.Address;
import com.idol.cafe.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Cafe extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cafe_id")
    private Long id;

    private String cafeName;
    private String introduction;
    private String imageUrl;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "cafe", cascade = ALL)
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Cafe(String cafeName, String introduction, String imageUrl, Address address, User user) {
        this.cafeName = cafeName;
        this.introduction = introduction;
        this.imageUrl = imageUrl;
        this.address = address;
        this.user = user;
    }

    public void updateCafe(String cafeName, String introduction, String imageUrl, User user) {
        this.cafeName = cafeName;
        this.introduction = introduction;
        this.imageUrl = imageUrl;
        this.user = user;
    }

}
