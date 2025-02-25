package com.microservice.development.team.application.find;

import com.microservice.development.shared.domain.TeamId;
import com.microservice.development.shared.domain.bus.query.QueryHandler;
import com.microservice.development.team.domain.TeamNotFoundException;

public final class FindTeamQueryHandler implements QueryHandler<FindTeamQuery, TeamResponse> {
    private final TeamFinder finder;

    public FindTeamQueryHandler(TeamFinder finder) {
        this.finder = finder;
    }

    @Override
    public TeamResponse handle(FindTeamQuery query) throws TeamNotFoundException {
        TeamId teamId = new TeamId(query.getTeamId());
        return this.finder.execute(teamId);
    }
}
