package com.idol.cafe.exception;

public class BusinessRegistrationError extends Exception {

    private static final String MESSAGE = "국세청에 등록되지 않은 사업자등록번호입니다.";

    public BusinessRegistrationError() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }

}
