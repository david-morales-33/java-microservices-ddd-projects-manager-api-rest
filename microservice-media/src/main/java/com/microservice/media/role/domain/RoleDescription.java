package com.microservice.media.role.domain;

import com.microservice.media.shared.domain.StringValueObject;

public final class RoleDescription extends StringValueObject {
    public RoleDescription(String value) {
        super(value);
    }

    private RoleDescription() {
        super(null);
    }
}
