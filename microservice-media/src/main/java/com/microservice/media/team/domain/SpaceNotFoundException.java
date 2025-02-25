package com.microservice.media.team.domain;


public final class SpaceNotFoundException extends RuntimeException {
    public SpaceNotFoundException(String value) {
        super(value);
    }
}
