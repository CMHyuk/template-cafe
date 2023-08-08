package com.idol.cafe.exception.jwt;

import com.idol.cafe.exception.Exception;

public class RefreshTokenExpiredException extends Exception {

    private static final String MESSAGE = "RefreshToken이 만료되었습니다.";

    public RefreshTokenExpiredException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 498;
    }

}
