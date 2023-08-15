package com.idol.cafe.exception;

public abstract class BircaException extends RuntimeException {

    public BircaException(String message) {
        super(message);
    }

    public abstract int getStatusCode();

}
