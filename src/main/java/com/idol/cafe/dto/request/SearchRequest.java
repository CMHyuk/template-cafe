package com.idol.cafe.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SearchRequest {
    private String idolName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String place;
}
