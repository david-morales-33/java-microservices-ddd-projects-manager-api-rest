package com.microservice.development.module.domain;

import com.microservice.development.shared.domain.StringValueObject;

public final class ModuleName extends StringValueObject {
    public ModuleName(String value) {
        super(value);
    }

    private ModuleName() {
        super(null);
    }
}
