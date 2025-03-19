package com.microservice.media.space.domain;

import com.microservice.media.shared.domain.WordTest;

public final class SpaceNameTest {
    public static SpaceName create(String value) {
        return new SpaceName(value);
    }

    public static SpaceName random() {
        return create(WordTest.random());
    }
}
