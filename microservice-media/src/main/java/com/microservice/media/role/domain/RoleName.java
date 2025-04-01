package com.microservice.media.role.domain;

import com.microservice.media.shared.domain.StringValueObject;

public final class RoleName extends StringValueObject {
    public RoleName(String value) {
        super(value);
    }

    public RoleName() {
        super(null);
    }
}
