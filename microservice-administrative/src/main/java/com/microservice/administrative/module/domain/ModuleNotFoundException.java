package com.microservice.administrative.module.domain;

public final class ModuleNotFoundException extends RuntimeException {
    public ModuleNotFoundException() {
        super("No se encontró el módulo solicitado");
    }
}
