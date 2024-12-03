package com.dmx.administrative.project.domain;

public class ProjectModuleAlreadyExistsException extends RuntimeException {
    public ProjectModuleAlreadyExistsException(String message) {
        super(message);
    }
}
