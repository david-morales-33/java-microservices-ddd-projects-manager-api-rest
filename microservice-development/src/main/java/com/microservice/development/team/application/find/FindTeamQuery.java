package com.microservice.development.team.application.find;

import com.microservice.development.shared.domain.bus.query.Query;

public final class FindTeamQuery implements Query {
    private final String teamId;

    public FindTeamQuery(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamId() {
        return teamId;
    }
}
