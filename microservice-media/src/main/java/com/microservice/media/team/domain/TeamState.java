package com.microservice.media.team.domain;

import com.microservice.media.shared.domain.BooleanValueObject;

public final class TeamState extends BooleanValueObject {
    public TeamState(boolean value) {
        super(value);
    }
}
