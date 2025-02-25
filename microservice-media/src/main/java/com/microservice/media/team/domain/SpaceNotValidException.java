package com.microservice.media.team.domain;


public final class SpaceNotValidException extends RuntimeException {
    public SpaceNotValidException(String value) {
        super(value);
    }
}
