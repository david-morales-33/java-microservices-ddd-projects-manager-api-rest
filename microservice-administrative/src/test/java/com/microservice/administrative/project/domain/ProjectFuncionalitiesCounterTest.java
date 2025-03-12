package com.microservice.administrative.project.domain;

import com.microservice.administrative.shared.domain.IntegerTest;

public final class ProjectFuncionalitiesCounterTest {
    public static ProjectFuncionalitiesCounter create(Integer value) {
        return new ProjectFuncionalitiesCounter(value);
    }

    public static ProjectFuncionalitiesCounter random() {
        return create(IntegerTest.random());
    }
}
