package com.dmx.administrative.team.application.find;

import com.dmx.administrative.team.domain.TeamDTO;
import com.dmx.shared.domain.bus.query.Response;

public final class TeamResponse implements Response {
    private final TeamDTO response;

    public TeamResponse(TeamDTO response) {
        this.response = response;
    }

    public TeamDTO getResponse() {
        return response;
    }
}
