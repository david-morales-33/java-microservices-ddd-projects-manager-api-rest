package com.microservice.media.space.domain;

import com.microservice.media.shared.domain.IntegerTest;

public final class SpaceMembersCounterTest {

    public static SpaceMembersCounter create(Integer value) {
        return new SpaceMembersCounter(value);
    }

    public static SpaceMembersCounter random() {
        return create(IntegerTest.random());
    }
}
