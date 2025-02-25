package com.microservice.administrative.team.domain;

import com.microservice.administrative.shared.domain.BooleanValueObject;

public final class TeamState extends BooleanValueObject {
    public TeamState(boolean value) {
        super(value);
    }
}
