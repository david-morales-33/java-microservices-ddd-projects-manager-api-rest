package com.microservice.development.module.domain;

import com.microservice.development.shared.domain.StringValueObject;

public final class ModuleCreationDate extends StringValueObject {
    public ModuleCreationDate(String value) {
        super(value);
    }

    private ModuleCreationDate() {
        super(null);
    }
}
