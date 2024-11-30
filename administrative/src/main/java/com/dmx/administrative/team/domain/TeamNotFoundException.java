package com.dmx.administrative.team.domain;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException() {
        super("El equipo no se encontró");
    }
}
