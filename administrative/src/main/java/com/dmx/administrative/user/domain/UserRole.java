package com.dmx.administrative.user.domain;

import com.dmx.administrative.role.domain.Role;
import com.dmx.administrative.role.domain.RoleDescription;
import com.dmx.administrative.role.domain.RoleName;
import com.dmx.shared.domain.RoleId;

public final class UserRole extends Role {
    public UserRole(RoleId id, RoleName name, RoleDescription description) {
        super(id, name, description);
    }
}
