package com.microservice.administrative.project.domain;

import com.microservice.administrative.shared.domain.IntegerTest;

public final class ProjectTeamCounterTest {
    public static ProjectTeamsCounter create(Integer value) {
        return new ProjectTeamsCounter(value);
    }

    public static ProjectTeamsCounter random() {
        return create(IntegerTest.random());
    }
}
