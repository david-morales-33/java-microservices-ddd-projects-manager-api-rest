package com.microservice.administrative.project.domain;

public final class ProjectNotFound extends RuntimeException {
    public ProjectNotFound(String message) {
        super(message);
    }
}
