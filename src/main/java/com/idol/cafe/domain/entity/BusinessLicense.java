package com.idol.cafe.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class BusinessLicense {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "business_licnese_id")
    private Long id;

    private String registrationNumber;

    public BusinessLicense(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

}
