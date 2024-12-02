package com.dmx.development.team.domain;

import com.dmx.development.role.domain.RoleDTO;
import com.dmx.development.user.domain.UserDTO;

import java.util.HashMap;

public record TeamDTO(
        String id,
        String name,
        int membersCounter,
        int spacesCounter,
        String creationDate,
        boolean state,
        RoleDTO role,
        HashMap<String, UserDTO> memberList
) {
}
