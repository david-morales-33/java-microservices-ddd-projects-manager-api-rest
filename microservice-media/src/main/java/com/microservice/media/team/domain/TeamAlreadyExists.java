package com.microservice.media.team.domain;

public class TeamAlreadyExists extends RuntimeException {
    public TeamAlreadyExists(String message) {
        super(message);
    }
}
