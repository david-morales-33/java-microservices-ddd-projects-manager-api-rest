package com.microservice.administrative.team.application.find;

import com.microservice.administrative.shared.domain.UuidTest;

public final class FindTeamQueryTest {
    public static FindTeamQuery create(String id) {
        return new FindTeamQuery(id);
    }

    public static FindTeamQuery random() {
        return create(UuidTest.random());
    }
}
