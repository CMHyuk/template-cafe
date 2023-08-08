package com.idol.cafe.exception.jwt;

import com.idol.cafe.exception.Exception;

public class Unauthorized extends Exception {

    private static final String MESSAGE = "인증이 필요합니다.";

    public Unauthorized() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 401;
    }

}
