package com.microservice.administrative.role.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class RoleDescriptionTest {
    public static RoleDescription create(String value) {
        return new RoleDescription(value);
    }

    public static RoleDescription random() {
        return create(WordTest.random());
    }
}
