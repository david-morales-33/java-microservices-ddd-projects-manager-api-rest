package com.microservice.media.team.application.find;

import com.microservice.media.team.domain.TeamIdTest;

public final class FindTeamQueryTest {
    public static FindTeamQuery create(String teamId) {
        return new FindTeamQuery(teamId);
    }

    public static FindTeamQuery random() {
        return create(TeamIdTest.random().value());
    }
}
