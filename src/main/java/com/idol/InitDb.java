package com.idol;

import com.idol.cafe.domain.entity.User;
import com.idol.cafe.repository.UserRepository;
import com.idol.cafe.service.JwtService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @PostConstruct
    public void init() {
        User user = User.builder()
                .email("alsgur9042@nate.com")
                .nickname("최민혁")
                .build();

        user.updateRoleType("admin");

        userRepository.save(user);

        String accessToken = jwtService.generateAccessToken(user.getId());
        System.out.println("accessToken = " + accessToken);
    }
}
