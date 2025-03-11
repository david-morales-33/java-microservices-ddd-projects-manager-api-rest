package com.microservice.administrative.team.domain;

import com.microservice.administrative.shared.domain.BooleanTest;

public final class TeamStateTest {
    public static TeamState create(Boolean value) {
        return new TeamState(value);
    }

    public static TeamState radom() {
        return create(BooleanTest.random());
    }
}
