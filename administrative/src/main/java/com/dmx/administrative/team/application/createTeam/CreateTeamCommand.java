package com.dmx.administrative.team.application.createTeam;

import com.dmx.shared.domain.bus.command.Command;

public class CreateTeamCommand implements Command {
    private final String teamId;
    private final String teamName;
    private final String roleId;
    private final String roleName;
    private final String roleDescription;

    public CreateTeamCommand(String teamId, String teamName, String roleId, String roleName, String roleDescription) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getTeamName() {
        return this.teamName;
    }
}
