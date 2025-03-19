package com.microservice.media.team.domain;

import com.microservice.media.shared.domain.BooleanTest;

public final class TeamStateTest {
    public static TeamState create(Boolean value) {
        return new TeamState(value);
    }
    public static TeamState random(){
        return create(BooleanTest.random());
    }
}
