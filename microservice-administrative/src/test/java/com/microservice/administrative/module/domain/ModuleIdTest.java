package com.microservice.administrative.module.domain;

import com.microservice.administrative.shared.domain.IntegerTest;
import com.microservice.administrative.shared.domain.ModuleId;
import com.microservice.administrative.shared.domain.UuidTest;

public final class ModuleIdTest {
    public static ModuleId create(Integer value) {
        return new ModuleId(value);
    }

    public static ModuleId random() {
        return create(IntegerTest.random());
    }
}
