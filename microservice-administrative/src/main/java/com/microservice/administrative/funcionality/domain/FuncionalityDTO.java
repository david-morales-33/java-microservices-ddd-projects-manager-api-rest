package com.microservice.administrative.funcionality.domain;

public record FuncionalityDTO(
        int id,
        String name,
        String description,
        String creationdate,
        boolean state,
        String teamId
) {
}
