package com.microservice.development.shared.domain;


public class ModuleId extends IntValueObject {
    public ModuleId(Integer value) {
        super(value);
    }

    private ModuleId() {
        super(null);
    }
}
