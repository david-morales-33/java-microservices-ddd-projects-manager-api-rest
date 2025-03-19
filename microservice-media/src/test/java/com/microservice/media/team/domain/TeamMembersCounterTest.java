package com.microservice.media.team.domain;

import com.microservice.media.shared.domain.IntegerTest;

public class TeamMembersCounterTest {
    public static TeamMembersCounter create(Integer value) {
        return new TeamMembersCounter(value);
    }

    public static TeamMembersCounter random() {
        return create(IntegerTest.random());
    }
}
