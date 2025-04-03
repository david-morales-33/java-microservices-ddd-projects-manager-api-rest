package com.microservice.media.space.domain;

import com.microservice.media.shared.domain.Identifier;
import com.microservice.media.shared.domain.UserId;

public final class SpaceCreateBy extends Identifier {
    public SpaceCreateBy(String value) {
        super(value);
    }

    public SpaceCreateBy() {
    }
}
