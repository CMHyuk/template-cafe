package com.idol.cafe.repository;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.dto.request.CafeSearchRequest;

import java.util.List;

public interface CafeRepositoryCustom {
    List<Cafe> getCafeResults(int page, CafeSearchRequest request);
}
