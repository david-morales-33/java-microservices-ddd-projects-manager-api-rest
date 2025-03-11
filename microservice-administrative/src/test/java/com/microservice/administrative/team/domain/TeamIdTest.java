package com.microservice.administrative.team.domain;

import com.microservice.administrative.shared.domain.TeamId;
import com.microservice.administrative.shared.domain.UuidTest;

public final class TeamIdTest {
    public static TeamId create(String value) {
        return new TeamId(value);
    }

    public static TeamId random() {
        return create(UuidTest.random());
    }
}
