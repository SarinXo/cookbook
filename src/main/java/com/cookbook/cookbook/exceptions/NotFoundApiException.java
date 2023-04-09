package com.cookbook.cookbook.exceptions;

public class NotFoundApiException extends RuntimeException {
    public NotFoundApiException(String message) {
        super(message);
    }
}
