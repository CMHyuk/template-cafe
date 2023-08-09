package com.idol.cafe.service;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.dto.request.SearchRequest;
import com.idol.cafe.repository.CafeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchService {

    private final CafeRepositoryImpl cafeRepository;

    public List<Cafe> search(SearchRequest request) {
        //1. 아이돌만 검색 2. 아이돌 + 날짜 3. 아이돌 + 장소 4. 아이돌 + 날짜 + 장소
        return cafeRepository.getResults(request);
    }

}
