package com.microservice.administrative.project.domain;

import com.microservice.administrative.shared.domain.IntegerTest;

public final class ProjectCardCounterTest {
    public static ProjectCardCounter create(Integer value) {
        return new ProjectCardCounter(value);
    }

    public static ProjectCardCounter random() {
        return create(IntegerTest.random());
    }
}
