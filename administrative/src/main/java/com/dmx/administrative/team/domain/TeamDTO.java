package com.dmx.administrative.team.domain;

import com.dmx.administrative.role.domain.RoleDTO;
import com.dmx.administrative.space.domain.SpaceDTO;

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
