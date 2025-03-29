package com.microservice.media.team.application.createTeam;

import com.microservice.media.role.domain.RoleDescription;
import com.microservice.media.role.domain.RoleName;
import com.microservice.media.shared.domain.RoleId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.bus.command.CommandHandler;
import com.microservice.media.team.domain.TeamCreationDate;
import com.microservice.media.team.domain.TeamName;

public final class CreateTeamCommandHandler implements CommandHandler<CreateTeamCommand> {
    private final TeamCreator creator;

    public CreateTeamCommandHandler(TeamCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateTeamCommand command) {
        TeamId teamId = new TeamId(command.getTeamId());
        TeamName teamName = new TeamName(command.getTeamName());
        TeamCreationDate teamCreationDate = new TeamCreationDate(command.getTeamCreationDate());
        RoleId roleId = new RoleId(command.getRoleId());
        RoleName roleName = new RoleName(command.getRoleName());
        RoleDescription roleDescription = new RoleDescription(command.getRoleDescription());
        this.creator.execute(teamId, teamName, teamCreationDate, roleId, roleName, roleDescription);
    }
}
