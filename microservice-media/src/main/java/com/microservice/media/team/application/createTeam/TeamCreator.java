package com.microservice.media.team.application.createTeam;

import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleDescription;
import com.microservice.media.role.domain.RoleName;
import com.microservice.media.shared.domain.RoleId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.space.domain.Space;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamCommandRepository;
import com.microservice.media.team.domain.TeamCreationDate;
import com.microservice.media.team.domain.TeamName;
import com.microservice.media.team.domain.TeamState;
import com.microservice.media.user.domain.User;

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
