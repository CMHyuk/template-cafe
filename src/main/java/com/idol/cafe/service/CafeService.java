package com.idol.cafe.service;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.domain.entity.User;
import com.idol.cafe.dto.request.CafeSearchRequest;
import com.idol.cafe.dto.request.LoginUser;
import com.idol.cafe.dto.request.SaveCafeRequest;
import com.idol.cafe.dto.response.CafeResponse;
import com.idol.cafe.dto.response.CafeSearchResponse;
import com.idol.cafe.exception.CafeNotFound;
import com.idol.cafe.exception.UserNotFound;
import com.idol.cafe.repository.CafeRepository;
import com.idol.cafe.repository.CafeRepositoryImpl;
import com.idol.cafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CafeService {

    private final UserRepository userRepository;
    private final CafeRepository cafeRepository;

    public Long saveCafe(LoginUser loginUser, SaveCafeRequest request) {
        User user = userRepository.findById(loginUser.getId())
                .orElseThrow(UserNotFound::new);

        Cafe cafe = Cafe.builder()
                .cafeName(request.getCafeName())
                .introduction(request.getIntroduction())
                .imageUrl(request.getImageUrl())
                .address(request.getAddress())
                .user(user)
                .build();

        return cafeRepository.save(cafe).getId();
    }

    public List<CafeSearchResponse> searchCafe(int page, CafeSearchRequest request) {
        //1. 아이돌 2. 아이돌 + 날짜 3. 아이돌 + 장소 4. 아이돌 + 날짜 + 장소 검색
        List<Cafe> cafes = cafeRepository.getCafeResults(page, request);
        return cafes.stream().map(c -> CafeSearchResponse.builder()
                        .cafeName(c.getCafeName())
                        .address(c.getAddress())
                        .imageUrl(c.getImageUrl())
                        .build())
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
