package com.dmx.development.team.application.find;

import com.dmx.development.shared.domain.TeamId;
import com.dmx.development.team.domain.Team;
import com.dmx.development.team.domain.TeamNotFoundException;
import com.dmx.development.team.domain.TeamQueryRepository;

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
