package com.dmx.administrative.project.domain;

public class ProjectAlreadyExists extends RuntimeException {
    public ProjectAlreadyExists(String message) {
        super(message);
    }
}
