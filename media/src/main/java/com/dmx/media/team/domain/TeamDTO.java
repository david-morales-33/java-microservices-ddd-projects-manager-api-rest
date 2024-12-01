package com.dmx.media.team.domain;

import com.dmx.media.role.domain.RoleDTO;
import com.dmx.media.space.domain.SpaceDTO;
import com.dmx.media.user.domain.UserDTO;

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
