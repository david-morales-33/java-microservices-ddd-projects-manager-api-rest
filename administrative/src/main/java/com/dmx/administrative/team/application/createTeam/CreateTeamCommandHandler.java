package com.dmx.administrative.team.application.createTeam;

import com.dmx.shared.domain.bus.command.CommandHandler;

public class CreateTeamCommandHandler implements CommandHandler<CreateTeamCommand> {
    private final TeamCreator creator;

    public CreateTeamCommandHandler(TeamCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateTeamCommand command) {
        String teamId = command.getTeamId();
        String teamName = command.getTeamName();
        String roleId = command.getRoleId();
        String roleName = command.getRoleName();
        String roleDescription = command.getRoleDescription();
        this.creator.execute(teamId, teamName, roleId, roleName, roleDescription);
    }
}
