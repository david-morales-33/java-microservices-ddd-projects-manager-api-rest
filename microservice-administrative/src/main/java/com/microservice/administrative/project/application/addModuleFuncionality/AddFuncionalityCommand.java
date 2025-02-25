package com.microservice.administrative.project.application.addModuleFuncionality;

import com.microservice.administrative.shared.domain.bus.command.Command;

public final class AddFuncionalityCommand implements Command {
    private final String projectId;
    private final String teamId;
    private final int funcionalityId;
    private final int moduleId;
    private final String name;
    private final String description;

    public AddFuncionalityCommand(
            String projectId,
            String teamId,
            int funcionalityId,
            int moduleId,
            String name,
            String description
    ) {
        this.projectId = projectId;
        this.teamId = teamId;
        this.funcionalityId = funcionalityId;
        this.moduleId = moduleId;
        this.name = name;
        this.description = description;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public int getFuncionalityId() {
        return this.funcionalityId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getModuleId() {
        return this.moduleId;
    }
}
