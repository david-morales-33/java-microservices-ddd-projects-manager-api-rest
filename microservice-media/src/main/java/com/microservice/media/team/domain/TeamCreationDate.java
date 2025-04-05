package com.microservice.media.team.domain;

import com.microservice.media.shared.domain.StringValueObject;

public final class TeamCreationDate extends StringValueObject {
    public TeamCreationDate(String value) {
        super(value);
    }

    private TeamCreationDate() {
        super(null);
    }
}
