package com.dmx.administrative.project.application.addTeam;

import com.dmx.administrative.role.domain.Role;
import com.dmx.administrative.role.domain.RoleDTO;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamCreationDate;
import com.dmx.administrative.team.domain.TeamName;
import com.dmx.administrative.team.domain.TeamState;
import com.dmx.administrative.user.domain.User;
import com.dmx.shared.domain.ProjectId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.bus.command.CommandHandler;

import java.time.LocalDate;
import java.util.HashMap;

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
