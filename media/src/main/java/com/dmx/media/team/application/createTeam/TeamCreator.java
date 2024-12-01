package com.dmx.media.team.application.createTeam;

import com.dmx.media.role.domain.Role;
import com.dmx.media.role.domain.RoleDescription;
import com.dmx.media.role.domain.RoleName;
import com.dmx.media.space.domain.Space;
import com.dmx.media.team.domain.*;
import com.dmx.media.user.domain.User;
import com.dmx.shared.domain.RoleId;
import com.dmx.shared.domain.TeamId;

import java.time.LocalDate;
import java.util.HashMap;

public final class TeamCreator {
    private final TeamCommandRepository commandRepository;

    public TeamCreator(TeamCommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public void execute(TeamId teamId, TeamName teamName, RoleId roleId, RoleName roleName, RoleDescription roleDescription) {
        TeamCreationDate creationDate = new TeamCreationDate(LocalDate.now().toString());
        TeamState teamState = new TeamState(true);
        Role role = new Role(roleId, roleName, roleDescription);
        HashMap<String, User> membersList = new HashMap<>();
        HashMap<String, Space> spaceList = new HashMap<>();
        Team team = Team.create(teamId, teamName, creationDate, teamState, role, membersList, spaceList);
        this.commandRepository.save(team);
    }
}
