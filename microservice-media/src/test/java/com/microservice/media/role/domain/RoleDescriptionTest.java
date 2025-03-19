package com.microservice.media.role.domain;

import com.microservice.media.shared.domain.WordTest;

public final class RoleDescriptionTest {
    public static RoleDescription create(String value) {
        return new RoleDescription(value);
    }

    public static RoleDescription random() {
        return create(WordTest.random());
    }
}
