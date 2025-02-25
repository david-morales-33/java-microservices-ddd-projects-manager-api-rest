package com.microservice.media.user.domain;

import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleDescription;
import com.microservice.media.role.domain.RoleName;
import com.microservice.media.shared.domain.RoleId;

public final class UserRole extends Role {
    public UserRole(RoleId id, RoleName name, RoleDescription description) {
        super(id, name, description);
    }
}
