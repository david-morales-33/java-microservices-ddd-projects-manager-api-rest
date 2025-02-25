package com.microservice.development.team.application.find;

import com.microservice.development.shared.domain.TeamId;
import com.microservice.development.team.domain.Team;
import com.microservice.development.team.domain.TeamNotFoundException;
import com.microservice.development.team.domain.TeamQueryRepository;

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
