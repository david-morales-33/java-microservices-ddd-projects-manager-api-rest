package com.dmx.administrative.project.application.addModuleFuncionality;

import com.dmx.administrative.funcionality.domain.*;
import com.dmx.shared.domain.FuncionalityId;
import com.dmx.shared.domain.ModuleId;
import com.dmx.shared.domain.ProjectId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.bus.command.CommandHandler;

import java.time.LocalDate;

public final class AddFuncionalityCommandHandler implements CommandHandler<AddFuncionalityCommand> {
    private final FuncionalityCreator creator;

    public AddFuncionalityCommandHandler(FuncionalityCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddFuncionalityCommand command) {
        FuncionalityId id = new FuncionalityId(command.getFuncionalityId());
        FuncionalityName name = new FuncionalityName(command.getName());
        FuncionalityDescription description = new FuncionalityDescription(command.getDescription());
        FuncionalityCreationdate creationdate = new FuncionalityCreationdate(LocalDate.now().toString());
        FuncionalityState state = new FuncionalityState(false);
        TeamId teamId = new TeamId(command.getTeamId());
        ProjectId projectId = new ProjectId(command.getProjectId());
        ModuleId moduleId = new ModuleId(command.getModuleId());
        Funcionality funcionality = Funcionality.create(id, name, description, creationdate, state, teamId);
        this.creator.execute(projectId, moduleId, funcionality);
    }
}
