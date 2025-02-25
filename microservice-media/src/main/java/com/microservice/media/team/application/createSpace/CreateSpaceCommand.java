package com.microservice.media.team.application.createSpace;

import com.microservice.media.shared.domain.bus.command.Command;

public final class CreateSpaceCommand implements Command {
    private final String teamId;
    private final String id;
    private final String name;
    private final String createBy;

    public CreateSpaceCommand(String teamId, String id, String name, String createBy) {
        this.teamId = teamId;
        this.id = id;
        this.name = name;
        this.createBy = createBy;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCreateBy() {
        return this.createBy;
    }
}
