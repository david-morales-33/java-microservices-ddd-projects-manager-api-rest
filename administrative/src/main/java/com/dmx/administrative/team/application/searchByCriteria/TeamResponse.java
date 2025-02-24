package com.dmx.administrative.team.application.searchByCriteria;

import com.dmx.administrative.shared.domain.bus.query.Response;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamDTO;

import java.util.ArrayList;
import java.util.List;

public final class TeamResponse implements Response {
    private final List<TeamDTO> response = new ArrayList<>();

    public TeamResponse(List<Team> data) {
        data.forEach((elements) -> {
            this.response.add(elements.toPrimitives());
        });
    }

    public List<TeamDTO> getResponse() {
        return this.response;
    }
}
