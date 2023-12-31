package com.idol.cafe.dto.request;

import com.idol.cafe.domain.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CafeSearchRequest {
    @NotBlank(message = "아이돌 입력은 필수사항입니다.")
    private String idolName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Address address;
}
