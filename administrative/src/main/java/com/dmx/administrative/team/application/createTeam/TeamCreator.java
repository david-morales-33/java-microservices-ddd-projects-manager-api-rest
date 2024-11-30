package com.dmx.administrative.team.application.createTeam;

import com.dmx.administrative.role.domain.Role;
import com.dmx.administrative.role.domain.RoleDescription;
import com.dmx.administrative.role.domain.RoleName;
import com.dmx.administrative.space.domain.Space;
import com.dmx.administrative.team.domain.*;
import com.dmx.administrative.user.domain.User;
import com.dmx.shared.domain.RoleId;
import com.dmx.shared.domain.TeamId;

import java.time.LocalDate;
import java.util.HashMap;

public class TeamCreator {
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
