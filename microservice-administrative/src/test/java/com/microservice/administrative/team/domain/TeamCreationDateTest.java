package com.microservice.administrative.team.domain;

import com.microservice.administrative.shared.domain.DateTest;

public final class TeamCreationDateTest {
    public static TeamCreationDate create(String value) {
        return new TeamCreationDate(value);
    }

    public static TeamCreationDate random() {
        return create(DateTest.random());
    }
}
