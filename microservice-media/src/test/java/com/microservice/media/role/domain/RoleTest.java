package com.microservice.media.role.domain;

import com.microservice.media.shared.domain.RoleId;

public final class RoleTest {
    public static Role create(RoleId id, RoleName name, RoleDescription description) {
        return new Role(id, name, description);
    }

    public static Role random() {
        return create(RoleIdTest.random(), RoleNameTest.random(), RoleDescriptionTest.random());
    }
}
