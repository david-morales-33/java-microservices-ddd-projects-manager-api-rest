package com.dmx.media.team.application.createTeam;

import com.dmx.media.role.domain.RoleDescription;
import com.dmx.media.role.domain.RoleName;
import com.dmx.media.team.domain.TeamName;
import com.dmx.shared.domain.RoleId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.bus.command.CommandHandler;

public final class CreateTeamCommandHandler implements CommandHandler<CreateTeamCommand> {
    private final TeamCreator creator;

    public CreateTeamCommandHandler(TeamCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateTeamCommand command) {
        TeamId teamId = new TeamId(command.getTeamId());
        TeamName teamName = new TeamName(command.getTeamName());
        RoleId roleId = new RoleId(command.getRoleId());
        RoleName roleName = new RoleName(command.getRoleName());
        RoleDescription roleDescription = new RoleDescription(command.getRoleDescription());
        this.creator.execute(teamId, teamName, roleId, roleName, roleDescription);
    }
}
