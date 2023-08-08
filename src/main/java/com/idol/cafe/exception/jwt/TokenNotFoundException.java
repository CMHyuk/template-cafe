package com.idol.cafe.exception.jwt;

import com.idol.cafe.exception.Exception;

public class TokenNotFoundException extends Exception {

    private static final String MESSAGE = "Token이 없습니다.";

    public TokenNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }

}
