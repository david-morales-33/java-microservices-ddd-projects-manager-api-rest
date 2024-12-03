package com.dmx.administrative.project.domain;

public final class ProjectNotFound extends RuntimeException {
    public ProjectNotFound(String message) {
        super(message);
    }
}
