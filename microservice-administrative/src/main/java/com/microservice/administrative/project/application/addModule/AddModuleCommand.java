package com.microservice.administrative.project.application.addModule;

import com.microservice.administrative.shared.domain.bus.command.Command;

public final class AddModuleCommand implements Command {
    private final String projectId;
    private final int moduleId;
    private final String name;
    private final String creationDate;

    public AddModuleCommand(String projectId, int moduleId, String name, String creationDate) {
        this.projectId = projectId;
        this.moduleId = moduleId;
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public String getName() {
        return this.name;
    }

    public String getCreationDate() {
        return this.creationDate;
    }
}
