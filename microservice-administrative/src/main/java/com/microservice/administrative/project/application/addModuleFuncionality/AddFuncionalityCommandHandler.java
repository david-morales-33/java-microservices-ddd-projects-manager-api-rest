package com.microservice.administrative.project.application.addModuleFuncionality;

import java.time.LocalDate;

import com.microservice.administrative.funcionality.domain.Funcionality;
import com.microservice.administrative.funcionality.domain.FuncionalityCreationdate;
import com.microservice.administrative.funcionality.domain.FuncionalityDescription;
import com.microservice.administrative.funcionality.domain.FuncionalityName;
import com.microservice.administrative.funcionality.domain.FuncionalityState;
import com.microservice.administrative.shared.domain.FuncionalityId;
import com.microservice.administrative.shared.domain.ModuleId;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.shared.domain.bus.command.CommandHandler;

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
