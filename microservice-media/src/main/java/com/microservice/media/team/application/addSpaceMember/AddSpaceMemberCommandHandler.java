package com.microservice.media.team.application.addSpaceMember;

import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.shared.domain.bus.command.CommandHandler;
import com.microservice.media.team.domain.TeamNotFoundException;

public final class AddSpaceMemberCommandHandler implements CommandHandler<AddSpaceMemberCommand> {
    private final SpaceMemberCreator creator;

    public AddSpaceMemberCommandHandler(SpaceMemberCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(AddSpaceMemberCommand command) throws TeamNotFoundException {
        TeamId teamId = new TeamId(command.getTeamId());
        SpaceId spaceId = new SpaceId(command.getSpaceId());
        UserId userId = new UserId(command.getUserId());
        this.creator.execute(teamId, spaceId, userId);
    }
}
