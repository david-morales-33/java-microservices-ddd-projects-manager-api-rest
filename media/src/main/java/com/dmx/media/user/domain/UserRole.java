package com.dmx.media.user.domain;

import com.dmx.media.role.domain.Role;
import com.dmx.media.role.domain.RoleDescription;
import com.dmx.media.role.domain.RoleName;
import com.dmx.media.shared.domain.RoleId;

public final class UserRole extends Role {
    public UserRole(RoleId id, RoleName name, RoleDescription description) {
        super(id, name, description);
    }
}
