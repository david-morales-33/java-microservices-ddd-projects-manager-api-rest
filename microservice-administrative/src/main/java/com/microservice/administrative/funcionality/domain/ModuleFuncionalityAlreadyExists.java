package com.microservice.administrative.funcionality.domain;

public final class ModuleFuncionalityAlreadyExists extends RuntimeException {
    public ModuleFuncionalityAlreadyExists(String message) {
        super(message);
    }
}
