package com.dmx.team.domain;

import com.dmx.role.domain.RoleDTO;
import com.dmx.space.domain.SpaceDTO;

public record TeamDTO(
        String id,
        String name,
        int membersCounter,
        int spacesCounter,
        String creationDate,
        boolean state,
        RoleDTO role,
        String[] memberList,
        SpaceDTO[] spaceList
) {
}
