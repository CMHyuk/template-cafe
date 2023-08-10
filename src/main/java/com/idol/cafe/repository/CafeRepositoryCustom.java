package com.idol.cafe.repository;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.dto.request.SearchRequest;

import java.util.List;

public interface CafeRepositoryCustom {
    List<Cafe> getCafeResults(SearchRequest request);
}
