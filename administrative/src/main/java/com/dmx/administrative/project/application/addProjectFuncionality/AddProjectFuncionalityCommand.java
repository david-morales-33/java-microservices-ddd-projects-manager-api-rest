package com.dmx.administrative.project.application.addProjectFuncionality;

import com.dmx.administrative.shared.domain.bus.command.Command;

public final class AddProjectFuncionalityCommand implements Command {
    private final String projectId;
    private final String teamId;
    private final int funcionalityId;
    private final String name;
    private final String description;

    public AddProjectFuncionalityCommand(
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

}
