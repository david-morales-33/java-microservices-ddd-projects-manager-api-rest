package com.microservice.media.space.domain;

public class SpaceMemberAlreadyExists extends RuntimeException {
    public SpaceMemberAlreadyExists() {
        super("El miembro ya existe");
    }
}
