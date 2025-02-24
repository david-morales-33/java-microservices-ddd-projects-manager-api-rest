package com.dmx.administrative.project.application.addCard;

import com.dmx.administrative.shared.domain.bus.command.Command;

public final class AddCardCommand implements Command {
    private final String projectId;
    private final String teamId;
    private final String name;

    public AddCardCommand(String projectId, String teamId, String name) {
        this.projectId = projectId;
        this.teamId = teamId;
        this.name = name;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getName() {
        return this.name;
    }
}
