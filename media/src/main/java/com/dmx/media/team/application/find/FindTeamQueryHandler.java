package com.dmx.media.team.application.find;

import com.dmx.media.shared.domain.TeamId;
import com.dmx.media.shared.domain.bus.query.QueryHandler;
import com.dmx.media.team.domain.TeamNotFoundException;

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
