package com.dmx.administrative.team.domain;

import com.dmx.administrative.role.domain.RoleDTO;
import com.dmx.administrative.space.domain.SpaceDTO;
import com.dmx.administrative.user.domain.UserDTO;

import java.util.HashMap;

public record TeamDTO(
        String id,
        String name,
        int membersCounter,
        int spacesCounter,
        String creationDate,
        boolean state,
        RoleDTO role,
        HashMap<String, UserDTO> memberList,
        HashMap<String, SpaceDTO> spaceList
) {
}
