package com.idol.cafe.exception.jwt;

import com.idol.cafe.exception.BircaException;

public class RefreshTokenExpiredBircaException extends BircaException {

    private static final String MESSAGE = "RefreshToken이 만료되었습니다.";

    public RefreshTokenExpiredBircaException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 498;
    }

}
