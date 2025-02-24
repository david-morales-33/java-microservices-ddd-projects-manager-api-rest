package com.dmx.development.team.application.addTeamMember;

import com.dmx.development.shared.domain.TeamId;
import com.dmx.development.shared.domain.UserId;
import com.dmx.development.shared.domain.bus.command.CommandHandler;
import com.dmx.development.team.domain.TeamNotFoundException;
import com.dmx.development.user.domain.UserNotFindException;

public final class AddTeamMemberCommandHandler implements CommandHandler<AddTeamMemberCommand> {
    private final TeamMemberCreator creator;

    public AddTeamMemberCommandHandler(TeamMemberCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddTeamMemberCommand command) throws UserNotFindException, TeamNotFoundException {
        TeamId teamId = new TeamId(command.getTeamId());
        UserId userId = new UserId(command.getUserId());
        this.creator.execute(teamId, userId);
    }
}
