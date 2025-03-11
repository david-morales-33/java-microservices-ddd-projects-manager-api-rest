package com.microservice.administrative.module.domain;

import com.microservice.administrative.shared.domain.DateTest;

public final class ModuleCreationDateTest {
    public static ModuleCreationDate create(String value) {
        return new ModuleCreationDate(value);
    }

    public static ModuleCreationDate random() {
        return create(DateTest.random());
    }
}
