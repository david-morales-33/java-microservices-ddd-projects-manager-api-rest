package com.microservice.media.team.domain;

import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UuidTest;

public final class TeamIdTest {
    public static TeamId create(String value) {
        return new TeamId(value);
    }

    public static TeamId random() {
        return create(UuidTest.random());
    }
}
