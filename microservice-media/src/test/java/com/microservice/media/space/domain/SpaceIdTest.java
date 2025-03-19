package com.microservice.media.space.domain;

import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.UuidTest;

public final class SpaceIdTest {
    public static SpaceId create(String value) {
        return new SpaceId(value);
    }

    public static SpaceId random() {
        return create(UuidTest.random());
    }
}
