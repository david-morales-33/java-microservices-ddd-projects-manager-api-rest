package com.microservice.media.space.domain;

import com.microservice.media.shared.domain.IntegerTest;

public final class SpacePostsCounterTest {

    public static SpacePostCounter create(Integer value) {
        return new SpacePostCounter(value);
    }

    public static SpacePostCounter random() {
        return create(IntegerTest.random());
    }
}
