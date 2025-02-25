package com.microservice.development.team.domain;

public final class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException() {
        super("El equipo no se encontró");
    }
}
