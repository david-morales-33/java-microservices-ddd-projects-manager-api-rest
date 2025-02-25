package com.microservice.media.team.domain;

import com.microservice.media.role.domain.RoleDTO;
import com.microservice.media.space.domain.SpaceDTO;
import com.microservice.media.user.domain.UserDTO;

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
