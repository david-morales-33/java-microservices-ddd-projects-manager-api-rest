package com.microservice.development.team.domain;

import com.microservice.development.shared.domain.StringValueObject;

public final class TeamCreationDate extends StringValueObject {
    public TeamCreationDate(String value) {
        super(value);
    }

    public TeamCreationDate() {
        super(null);
    }
}
