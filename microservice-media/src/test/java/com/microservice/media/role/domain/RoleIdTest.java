package com.microservice.media.role.domain;

import com.microservice.media.shared.domain.RoleId;
import com.microservice.media.shared.domain.UuidTest;

public final class RoleIdTest {

    public static RoleId create(String value) {
        return new RoleId(value);
    }

    public static RoleId random() {
        return create(UuidTest.random());
    }
}
