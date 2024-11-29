package com.dmx.administrative.team.application.createTeam;

import com.dmx.administrative.role.domain.Role;
import com.dmx.administrative.role.domain.RoleDescription;
import com.dmx.administrative.role.domain.RoleName;
import com.dmx.administrative.team.domain.*;
import com.dmx.shared.domain.RoleId;
import com.dmx.shared.domain.TeamId;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class TeamCreator {
    private final TeamCommandRepository commandRepository;

    public TeamCreator(TeamCommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public void execute(String teamId, String teamName, String roleId, String roleName, String roleDescription){
        Team team = Team.create(
                new TeamId(teamId),
                new TeamName(teamName),
                new TeamCreationDate(new Date().toString()),
                new TeamState(true),
                Role.create(
                        new RoleId(roleId),
                        new RoleName(roleName),
                        new RoleDescription(roleDescription)
                ),
                new HashSet<>(),
                new HashMap<>()
        );
        this.commandRepository.save(team);
    }
}
