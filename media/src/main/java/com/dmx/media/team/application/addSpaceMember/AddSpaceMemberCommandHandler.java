package com.dmx.media.team.application.addSpaceMember;

import com.dmx.media.team.domain.TeamNotFoundException;
import com.dmx.shared.domain.SpaceId;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.UserId;
import com.dmx.shared.domain.bus.command.CommandHandler;

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
