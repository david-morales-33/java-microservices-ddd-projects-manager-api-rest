package com.dmx.administrative.team.application.addTeamMember;

import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.UserId;
import com.dmx.shared.domain.bus.command.CommandHandler;

public final class AddTeamMemberCommandHandler implements CommandHandler<AddTeamMemberCommand> {
    private final TeamMemberCreator creator;

    public AddTeamMemberCommandHandler(TeamMemberCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddTeamMemberCommand command) {
        TeamId teamId = new TeamId(command.getTeamId());
        UserId userId = new UserId(command.getUserId());
        this.creator.execute(teamId, userId);
    }
}
