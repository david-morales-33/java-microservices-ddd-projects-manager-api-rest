package com.dmx.administrative.project.domain;

public final class ProjectModuleNotExistsException extends RuntimeException {
    public ProjectModuleNotExistsException(String message) {
        super(message);
    }
}
