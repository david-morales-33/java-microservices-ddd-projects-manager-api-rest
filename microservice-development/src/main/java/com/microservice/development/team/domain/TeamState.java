package com.microservice.development.team.domain;

import com.microservice.development.shared.domain.BooleanValueObject;

public final class TeamState extends BooleanValueObject {
    public TeamState(boolean value) {
        super(value);
    }
}
