package com.microservice.administrative.project.application.addProjectFuncionality;

import java.time.LocalDate;

import com.microservice.administrative.funcionality.domain.Funcionality;
import com.microservice.administrative.funcionality.domain.FuncionalityCreationdate;
import com.microservice.administrative.funcionality.domain.FuncionalityDescription;
import com.microservice.administrative.funcionality.domain.FuncionalityName;
import com.microservice.administrative.funcionality.domain.FuncionalityState;
import com.microservice.administrative.shared.domain.FuncionalityId;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.Service;
import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.shared.domain.bus.command.CommandHandler;

@Service
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
