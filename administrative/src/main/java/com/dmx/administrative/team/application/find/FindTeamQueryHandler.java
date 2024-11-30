package com.dmx.administrative.team.application.find;

import com.dmx.administrative.team.domain.TeamNotFoundException;
import com.dmx.shared.domain.TeamId;
import com.dmx.shared.domain.bus.query.QueryHandler;

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
