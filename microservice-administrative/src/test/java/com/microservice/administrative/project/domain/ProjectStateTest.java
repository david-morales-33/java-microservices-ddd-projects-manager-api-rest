package com.microservice.administrative.project.domain;

import com.microservice.administrative.shared.domain.FloatTest;

public final class ProjectStateTest {
    public static ProjectState create(Float value) {
        return new ProjectState(value);
    }

    public static ProjectState random() {
        return create(FloatTest.random());
    }
}
