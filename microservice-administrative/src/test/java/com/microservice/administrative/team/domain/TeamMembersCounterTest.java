package com.microservice.administrative.team.domain;

import com.microservice.administrative.shared.domain.IntegerTest;

public final class TeamMembersCounterTest {
    public static TeamMembersCounter create(Integer value) {
        return new TeamMembersCounter(value);
    }

    public static TeamMembersCounter random() {
        return create(IntegerTest.random());
    }
}
