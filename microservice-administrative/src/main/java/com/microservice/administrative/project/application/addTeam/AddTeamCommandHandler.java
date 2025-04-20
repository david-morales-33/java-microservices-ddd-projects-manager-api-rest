package com.microservice.administrative.project.application.addTeam;

import java.time.LocalDate;
import java.util.HashMap;

import com.microservice.administrative.role.domain.Role;
import com.microservice.administrative.role.domain.RoleDTO;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.Service;
import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.shared.domain.bus.command.CommandHandler;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamCreationDate;
import com.microservice.administrative.team.domain.TeamName;
import com.microservice.administrative.team.domain.TeamState;
import com.microservice.administrative.user.domain.User;

@Service
public final class AddTeamCommandHandler implements CommandHandler<AddTeamCommand> {
    private final TeamCreator creator;

    public AddTeamCommandHandler(TeamCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddTeamCommand command) {
        ProjectId projectId = new ProjectId(command.getProjectId());
        Role role = Role.fromPrimitives(new RoleDTO(command.getRoleId(), "No defined", "Not defined"));
        TeamId id = new TeamId(command.getTeamId());
        TeamName name = new TeamName(command.getName());
        TeamCreationDate creationDate = new TeamCreationDate(LocalDate.now().toString());
        TeamState state = new TeamState(true);
        HashMap<String, User> members = new HashMap<>();
        Team team = Team.create(id, name, creationDate, state, role, members);

        this.creator.execute(projectId, team);
    }
}
