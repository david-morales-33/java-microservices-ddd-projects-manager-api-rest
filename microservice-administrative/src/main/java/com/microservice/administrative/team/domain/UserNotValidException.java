package com.microservice.administrative.team.domain;


public final class UserNotValidException extends RuntimeException {
    public UserNotValidException(String value) {
        super(value);
    }
}
