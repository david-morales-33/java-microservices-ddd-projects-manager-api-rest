package com.microservice.administrative.project.application.createFuncionalitiesProject;

import com.microservice.administrative.project.domain.ProjectName;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.Service;
import com.microservice.administrative.shared.domain.bus.command.CommandHandler;

@Service
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
