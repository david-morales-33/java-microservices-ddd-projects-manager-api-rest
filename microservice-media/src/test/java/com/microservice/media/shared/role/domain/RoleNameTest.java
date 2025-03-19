package com.microservice.media.shared.role.domain;

import com.microservice.media.role.domain.RoleName;
import com.microservice.media.shared.domain.WordTest;

public final class RoleNameTest {
    public static RoleName create(String value) {
        return new RoleName(value);
    }

    public static RoleName random() {
        return create(WordTest.random());
    }
}
