package com.dmx.user.domain;

import com.dmx.role.domain.Role;
import com.dmx.role.domain.RoleDescription;
import com.dmx.role.domain.RoleName;
import com.dmx.shared.domain.RoleId;

public class UserRole extends Role {
    public UserRole(RoleId id, RoleName name, RoleDescription description) {
        super(id, name, description);
    }
}
