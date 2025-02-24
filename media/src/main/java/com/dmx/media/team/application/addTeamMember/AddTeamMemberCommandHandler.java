package com.dmx.media.team.application.addTeamMember;

import com.dmx.media.shared.domain.TeamId;
import com.dmx.media.shared.domain.UserId;
import com.dmx.media.shared.domain.bus.command.CommandHandler;
import com.dmx.media.team.domain.TeamNotFoundException;
import com.dmx.media.user.domain.UserNotFindException;

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
