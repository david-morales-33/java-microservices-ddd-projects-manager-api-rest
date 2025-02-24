package com.dmx.administrative.team.application.addTeamMember;

import com.dmx.administrative.shared.domain.TeamId;
import com.dmx.administrative.shared.domain.UserId;
import com.dmx.administrative.shared.domain.bus.command.CommandHandler;
import com.dmx.administrative.team.domain.TeamNotFoundException;
import com.dmx.administrative.user.domain.UserNotFindException;
;

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
