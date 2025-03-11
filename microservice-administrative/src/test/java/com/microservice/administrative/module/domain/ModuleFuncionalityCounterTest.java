package com.microservice.administrative.module.domain;

import com.microservice.administrative.shared.domain.IntegerTest;

public final class ModuleFuncionalityCounterTest {
    public static ModuleFuncionalitiesCounter create(Integer value) {
        return new ModuleFuncionalitiesCounter(value);
    }

    public static ModuleFuncionalitiesCounter random() {
        return create(IntegerTest.random());
    }
}
