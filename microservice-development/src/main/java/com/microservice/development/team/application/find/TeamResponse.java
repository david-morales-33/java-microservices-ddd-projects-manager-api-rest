package com.microservice.development.team.application.find;

import com.microservice.development.shared.domain.bus.query.Response;
import com.microservice.development.team.domain.TeamDTO;

public final class TeamResponse implements Response {
    private final TeamDTO response;

    public TeamResponse(TeamDTO response) {
        this.response = response;
    }

    public TeamDTO getResponse() {
        return response;
    }
}
