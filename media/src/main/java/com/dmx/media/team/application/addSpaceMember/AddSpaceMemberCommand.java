package com.dmx.media.team.application.addSpaceMember;

import com.dmx.media.shared.domain.bus.command.Command;

public final class AddSpaceMemberCommand implements Command {
    private final String userId;
    private final String teamId;
    private final String spaceId;

    public AddSpaceMemberCommand(String userId, String teamId, String spaceIdId) {
        this.userId = userId;
        this.teamId = teamId;
        this.spaceId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getSpaceId() {
        return spaceId;
    }
}
