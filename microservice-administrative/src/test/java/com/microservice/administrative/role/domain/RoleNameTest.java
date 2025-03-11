package com.microservice.administrative.role.domain;

import com.microservice.administrative.shared.domain.WordTest;

public final class RoleNameTest {
    public static RoleName create(String value) {
        return new RoleName(value);
    }

    public static RoleName random() {
        return create(WordTest.random());
    }
}
