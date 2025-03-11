package com.microservice.administrative.team.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class TeamNameTest {
    public static TeamName create(String value) {
        return new TeamName(value);
    }

    public static TeamName random() {
        return create(WordTest.random());
    }
}
