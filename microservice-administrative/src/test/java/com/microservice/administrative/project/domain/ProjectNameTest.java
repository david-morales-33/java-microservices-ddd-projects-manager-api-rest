package com.microservice.administrative.project.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class ProjectNameTest {
    public static ProjectName create(String value) {
        return new ProjectName(value);
    }

    public static ProjectName random() {
        return create(WordTest.random());
    }
}
