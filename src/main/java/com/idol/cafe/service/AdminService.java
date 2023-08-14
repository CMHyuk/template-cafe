package com.idol.cafe.service;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.dto.response.CafeResponse;
import com.idol.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final CafeRepository cafeRepository;

    public List<CafeResponse> getCafes(Pageable pageable) {
        Page<Cafe> cafes = cafeRepository.findAll(pageable);
        return cafes.stream().map(c -> CafeResponse.builder()
                        .cafeName(c.getCafeName())
                        .introduction(c.getIntroduction())
                        .imageUrl(c.getImageUrl())
                        .build())
                .collect(toList());
    }
}
