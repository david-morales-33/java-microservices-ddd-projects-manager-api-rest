package com.dmx.administrative.team.domain;

import com.dmx.administrative.role.domain.RoleDTO;
import com.dmx.administrative.space.domain.SpaceDTO;

import java.util.HashMap;
import java.util.HashSet;

public record TeamDTO(
        String id,
        String name,
        int membersCounter,
        int spacesCounter,
        String creationDate,
        boolean state,
        RoleDTO role,
        HashSet<String> memberList,
        HashMap<String, SpaceDTO> spaceList
) {
}
