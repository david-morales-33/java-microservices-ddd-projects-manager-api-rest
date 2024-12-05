package com.dmx.administrative.team.domain;

import com.dmx.administrative.role.domain.RoleDTO;
import com.dmx.administrative.user.domain.UserDTO;

import java.util.HashMap;

public record TeamDTO(
        String id,
        String name,
        int membersCounter,
        String creationDate,
        boolean state,
        RoleDTO role,
        HashMap<String, UserDTO> memberList
) {
}
