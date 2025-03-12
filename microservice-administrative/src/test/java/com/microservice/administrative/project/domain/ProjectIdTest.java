package com.microservice.administrative.project.domain;

import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.UuidTest;

public final class ProjectIdTest {
    public static ProjectId create(String value) {
        return new ProjectId(value);
    }

    public static ProjectId random() {
        return create(UuidTest.random());
    }
}
