package com.microservice.administrative.project.application.createFuncionalitiesProject;

import com.microservice.administrative.shared.domain.bus.command.Command;

public final class CreateProjectCommand implements Command {
    private final String id;
    private final String name;

    public CreateProjectCommand(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
