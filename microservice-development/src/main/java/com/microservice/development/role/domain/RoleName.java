package com.microservice.development.role.domain;

import com.microservice.development.shared.domain.StringValueObject;

public final class RoleName extends StringValueObject {
    public RoleName(String value) {
        super(value);
    }

    private RoleName() {
        super(null);
    }
}
