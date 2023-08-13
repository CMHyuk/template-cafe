package com.idol.cafe.service;

import com.idol.cafe.domain.entity.Cafe;
import com.idol.cafe.domain.entity.User;
import com.idol.cafe.dto.request.LoginUser;
import com.idol.cafe.dto.request.SaveCafeRequest;
import com.idol.cafe.dto.response.CafeResponse;
import com.idol.cafe.exception.UserNotFound;
import com.idol.cafe.repository.CafeRepository;
import com.idol.cafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.*;

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
