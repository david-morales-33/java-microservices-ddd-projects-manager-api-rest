package com.microservice.media.team.domain;

import com.microservice.media.shared.domain.IntegerTest;

public final class TeamSpaceCounterTest {
    public static TeamSpacesCounter create(Integer value) {
        return new TeamSpacesCounter(value);
    }

    public static TeamSpacesCounter random() {
        return create(IntegerTest.random());
    }
}
