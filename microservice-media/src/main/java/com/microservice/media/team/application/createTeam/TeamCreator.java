package com.microservice.media.team.application.createTeam;

import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleDescription;
import com.microservice.media.role.domain.RoleName;
import com.microservice.media.shared.domain.RoleId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.space.domain.Space;
import com.microservice.media.team.domain.*;
import com.microservice.media.user.domain.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

public final class TeamCreator {
    private final TeamCommandRepository commandRepository;
    private final TeamQueryRepository queryRepository;

    public TeamCreator(TeamCommandRepository commandRepository, TeamQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public void execute(TeamId teamId, TeamName teamName, TeamCreationDate creationDate, RoleId roleId, RoleName roleName, RoleDescription roleDescription) {
        Optional<Team> response = this.queryRepository.find(teamId);

        if (response.isPresent()) throw new TeamAlreadyExists("El equipo ya existe");

        TeamState teamState = new TeamState(true);
        Role role = new Role(roleId, roleName, roleDescription);
        HashMap<String, User> membersList = new HashMap<>();
        HashMap<String, Space> spaceList = new HashMap<>();
        Team team = Team.create(teamId, teamName, creationDate, teamState, role, membersList, spaceList);
        this.commandRepository.save(team);
    }
}
