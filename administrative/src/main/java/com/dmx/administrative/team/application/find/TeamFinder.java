package com.dmx.administrative.team.application.find;

import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamNotFoundException;
import com.dmx.administrative.team.domain.TeamQueryRepository;
import com.dmx.shared.domain.TeamId;

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
