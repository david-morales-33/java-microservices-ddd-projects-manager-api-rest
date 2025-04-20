package com.microservice.media.team.application.find;

import com.microservice.media.shared.domain.Service;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.bus.query.QueryHandler;
import com.microservice.media.team.domain.TeamNotFoundException;

@Service
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
