package com.dmx.administrative.project.domain;

public class ProjectModuleNotExistsException extends RuntimeException {
    public ProjectModuleNotExistsException(String message) {
        super(message);
    }
}
