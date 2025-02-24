package com.dmx.development.team.application.find;

import com.dmx.development.shared.domain.bus.query.Response;
import com.dmx.development.team.domain.TeamDTO;

public final class TeamResponse implements Response {
    private final TeamDTO response;

    public TeamResponse(TeamDTO response) {
        this.response = response;
    }

    public TeamDTO getResponse() {
        return response;
    }
}
