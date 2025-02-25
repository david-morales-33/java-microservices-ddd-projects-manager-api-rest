package com.microservice.development.task.domain;

public record TaskDTO(
        String id,
        String name,
        String description,
        String creationDate,
        boolean state,
        String createBy
) {
}
