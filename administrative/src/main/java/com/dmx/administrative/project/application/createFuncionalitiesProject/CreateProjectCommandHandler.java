package com.dmx.administrative.project.application.createFuncionalitiesProject;

import com.dmx.administrative.project.application.createModuleProject.CreateProjectCommand;
import com.dmx.administrative.project.application.createModuleProject.ProjectCreator;
import com.dmx.administrative.project.domain.ProjectName;
import com.dmx.shared.domain.ProjectId;
import com.dmx.shared.domain.bus.command.CommandHandler;

public final class CreateProjectCommandHandler implements CommandHandler<com.dmx.administrative.project.application.createModuleProject.CreateProjectCommand> {
    private final com.dmx.administrative.project.application.createModuleProject.ProjectCreator creator;

    public CreateProjectCommandHandler(ProjectCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateProjectCommand command) {
        ProjectId projectId = new ProjectId(command.getId());
        ProjectName projectName = new ProjectName(command.getName());
        this.creator.execute(projectId, projectName);
    }
}
