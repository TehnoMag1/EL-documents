package com.example.eldocuments.common.exceptions;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {}

    public ForbiddenException(final String message) {
        super(message);
    }
}
