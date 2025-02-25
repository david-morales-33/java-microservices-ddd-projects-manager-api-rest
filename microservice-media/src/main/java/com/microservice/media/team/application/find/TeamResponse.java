package com.microservice.media.team.application.find;

import com.microservice.media.shared.domain.bus.query.Response;
import com.microservice.media.team.domain.TeamDTO;

public final class TeamResponse implements Response {
    private final TeamDTO response;

    public TeamResponse(TeamDTO response) {
        this.response = response;
    }

    public TeamDTO getResponse() {
        return response;
    }
}
