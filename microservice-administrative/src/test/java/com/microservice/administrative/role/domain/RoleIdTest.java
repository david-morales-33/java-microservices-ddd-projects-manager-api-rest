package com.microservice.administrative.role.domain;

import com.microservice.administrative.shared.domain.RoleId;
import com.microservice.administrative.shared.domain.UuidTest;

public final class RoleIdTest {

    public static RoleId create(String value) {
        return new RoleId(value);
    }

    public static RoleId random() {
        return create(UuidTest.random());
    }
}
