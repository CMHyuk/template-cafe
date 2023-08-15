package com.idol.cafe.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AdminBusinessLicenseResponse {

    private final Long businessLicenseId;
    private final String registrationNumber;
    private final String nickname;
    private final LocalDateTime localDateTime;
    private final Boolean isRegisteredBusiness;

    @Builder
    public AdminBusinessLicenseResponse(Long businessLicenseId, String registrationNumber, String nickname,
                                        LocalDateTime localDateTime, Boolean isRegisteredBusiness) {
        this.businessLicenseId = businessLicenseId;
        this.registrationNumber = registrationNumber;
        this.nickname = nickname;
        this.localDateTime = localDateTime;
        this.isRegisteredBusiness = isRegisteredBusiness;
    }
}
