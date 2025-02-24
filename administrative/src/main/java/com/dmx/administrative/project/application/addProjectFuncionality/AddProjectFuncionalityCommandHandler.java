package com.dmx.administrative.project.application.addProjectFuncionality;

import com.dmx.administrative.funcionality.domain.*;
import com.dmx.administrative.shared.domain.FuncionalityId;
import com.dmx.administrative.shared.domain.ProjectId;
import com.dmx.administrative.shared.domain.TeamId;
import com.dmx.administrative.shared.domain.bus.command.CommandHandler;

import java.time.LocalDate;

public final class AddProjectFuncionalityCommandHandler implements CommandHandler<AddProjectFuncionalityCommand> {
    private final ProjectFuncionalityCreator creator;

    public AddProjectFuncionalityCommandHandler(ProjectFuncionalityCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddProjectFuncionalityCommand command) {
        FuncionalityId id = new FuncionalityId(command.getFuncionalityId());
        FuncionalityName name = new FuncionalityName(command.getName());
        FuncionalityDescription description = new FuncionalityDescription(command.getDescription());
        FuncionalityCreationdate creationdate = new FuncionalityCreationdate(LocalDate.now().toString());
        FuncionalityState state = new FuncionalityState(false);
        TeamId teamId = new TeamId(command.getTeamId());
        ProjectId projectId = new ProjectId(command.getProjectId());
        Funcionality funcionality = Funcionality.create(id, name, description, creationdate, state, teamId);
        this.creator.execute(projectId, funcionality);
    }
}
