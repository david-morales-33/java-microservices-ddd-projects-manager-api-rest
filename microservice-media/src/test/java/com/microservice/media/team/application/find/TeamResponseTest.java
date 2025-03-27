package com.microservice.media.team.application.find;

import com.microservice.media.team.domain.TeamDTO;
import com.microservice.media.team.domain.TeamTest;

public final class TeamResponseTest {
    public static TeamResponse create(TeamDTO team) {
        return new TeamResponse(team);
    }

    public static TeamResponse random() {
        return create(TeamTest.random().toPrimitives());
    }
}
