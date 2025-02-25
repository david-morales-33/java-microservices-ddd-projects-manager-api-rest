package com.microservice.administrative.team.application.find;

import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamNotFoundException;
import com.microservice.administrative.team.domain.TeamQueryRepository;

import java.util.Optional;

public final class TeamFinder {
    private final TeamQueryRepository queryRepository;

    public TeamFinder(TeamQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public TeamResponse execute(TeamId teamId) throws TeamNotFoundException {
        Optional<Team> response = this.queryRepository.find(teamId);
        if (response.isEmpty()) throw new TeamNotFoundException();

        Team team = response.get();
        return new TeamResponse(team.toPrimitives());
    }
}
