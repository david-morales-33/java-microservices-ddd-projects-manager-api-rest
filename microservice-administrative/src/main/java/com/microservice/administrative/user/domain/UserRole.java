package com.microservice.administrative.user.domain;

import com.microservice.administrative.role.domain.Role;
import com.microservice.administrative.role.domain.RoleDescription;
import com.microservice.administrative.role.domain.RoleName;
import com.microservice.administrative.shared.domain.RoleId;

public final class UserRole extends Role {
    public UserRole(RoleId id, RoleName name, RoleDescription description) {
        super(id, name, description);
    }
}
