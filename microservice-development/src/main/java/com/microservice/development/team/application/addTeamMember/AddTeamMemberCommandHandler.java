package com.microservice.development.team.application.addTeamMember;

import com.microservice.development.shared.domain.TeamId;
import com.microservice.development.shared.domain.UserId;
import com.microservice.development.shared.domain.bus.command.CommandHandler;
import com.microservice.development.team.domain.TeamNotFoundException;
import com.microservice.development.user.domain.UserNotFindException;

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
