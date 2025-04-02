package com.microservice.media.space.domain;

import com.microservice.media.shared.domain.StringValueObject;

public final class SpaceCreationDate extends StringValueObject {
    public SpaceCreationDate(String value) {
        super(value);
    }

    private SpaceCreationDate() {
        super(null);
    }
}
