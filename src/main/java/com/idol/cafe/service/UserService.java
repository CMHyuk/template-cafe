package com.idol.cafe.service;

import com.idol.cafe.domain.entity.User;
import com.idol.cafe.dto.response.kakao.GetMemberInfoResponse;
import com.idol.cafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long saveFromKakao(GetMemberInfoResponse userInfo) {
        User user = User.builder()
                .nickname(userInfo.getKakaoAccount().getProfile().getNickname())
                .email(userInfo.getKakaoAccount().getEmail())
                .build();
        return saveUser(user);
    }

    private Long saveUser(User user) {
        log.info("email = {}", user.getEmail());
        return userRepository.findByEmail(user.getEmail())
                .map(User::getId)
                .orElseGet(() -> userRepository.save(user).getId());
    }

}
