package com.idol.cafe.exception.jwt;

import com.idol.cafe.exception.BircaException;

public class TokenNotFoundBircaException extends BircaException {

    private static final String MESSAGE = "Token이 없습니다.";

    public TokenNotFoundBircaException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }

}
