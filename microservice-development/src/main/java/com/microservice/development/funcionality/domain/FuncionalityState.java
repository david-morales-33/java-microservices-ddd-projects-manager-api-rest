package com.microservice.development.funcionality.domain;

import com.microservice.development.shared.domain.BooleanValueObject;

public final class FuncionalityState extends BooleanValueObject {
    public FuncionalityState(boolean value) {
        super(value);
    }

    public FuncionalityState() {
        super(null);
    }
}
