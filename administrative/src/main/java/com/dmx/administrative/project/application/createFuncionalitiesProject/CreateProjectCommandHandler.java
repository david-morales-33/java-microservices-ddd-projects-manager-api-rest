package com.dmx.administrative.project.application.createFuncionalitiesProject;

import com.dmx.administrative.project.domain.ProjectName;
import com.dmx.administrative.shared.domain.ProjectId;
import com.dmx.administrative.shared.domain.bus.command.CommandHandler;

public final class CreateProjectCommandHandler implements CommandHandler<CreateProjectCommand> {
    private final ProjectCreator creator;

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
