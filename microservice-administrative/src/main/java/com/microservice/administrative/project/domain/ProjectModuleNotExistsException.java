package com.microservice.administrative.project.domain;

public final class ProjectModuleNotExistsException extends RuntimeException {
    public ProjectModuleNotExistsException(String message) {
        super(message);
    }
}
