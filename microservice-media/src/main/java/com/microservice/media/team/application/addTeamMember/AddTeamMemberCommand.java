package com.microservice.media.team.application.addTeamMember;

import com.microservice.media.shared.domain.bus.command.Command;

public final class AddTeamMemberCommand implements Command {
    private final String userId;
    private final String teamId;

    public AddTeamMemberCommand(String userId, String teamId) {
        this.userId = userId;
        this.teamId = teamId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getTeamId() {
        return this.teamId;
    }
}
