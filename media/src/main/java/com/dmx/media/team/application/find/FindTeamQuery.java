package com.dmx.media.team.application.find;

import com.dmx.shared.domain.bus.query.Query;

public final class FindTeamQuery implements Query {
    private final String teamId;

    public FindTeamQuery(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamId() {
        return teamId;
    }
}
