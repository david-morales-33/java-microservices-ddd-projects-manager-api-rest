package com.dmx.administrative.project.domain;

public final class ProjectModuleAlreadyExistsException extends RuntimeException {
    public ProjectModuleAlreadyExistsException(String message) {
        super(message);
    }
}
