package com.idol.cafe.service;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.dto.request.CafeSearchRequest;
import com.idol.cafe.dto.response.CafeResponse;
import com.idol.cafe.dto.response.CafeSearchResponse;
import com.idol.cafe.exception.CafeNotFound;
import com.idol.cafe.repository.CafeRepository;
import com.idol.cafe.repository.CafeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchService {

    private final CafeRepositoryImpl cafeRepositoryImpl;
    private final CafeRepository cafeRepository;

    public List<CafeSearchResponse> searchCafe(CafeSearchRequest request) {
        //1. 아이돌만 검색 2. 아이돌 + 날짜 3. 아이돌 + 장소 4. 아이돌 + 날짜 + 장소
        List<Cafe> cafes = cafeRepositoryImpl.getCafeResults(request);
        return cafes.stream().map(c -> new CafeSearchResponse(c.getCafeName(), c.getAddress()))
                .collect(toList());
    }

    public CafeResponse getCafeDetails(Long cafeId) {
        Cafe cafe = cafeRepository.findById(cafeId)
                .orElseThrow(CafeNotFound::new);

        return CafeResponse.builder()
                .cafeId(cafe.getId())
                .cafeName(cafe.getCafeName())
                .introduction(cafe.getIntroduction())
                .imageUrl(cafe.getImageUrl())
                .build();
    }

}
