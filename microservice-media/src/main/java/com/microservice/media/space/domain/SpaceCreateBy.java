package com.microservice.media.space.domain;

import com.microservice.media.shared.domain.UserId;

public final class SpaceCreateBy extends UserId {
    public SpaceCreateBy(String value) {
        super(value);
    }

    public SpaceCreateBy() {
        super(null);
    }
}
