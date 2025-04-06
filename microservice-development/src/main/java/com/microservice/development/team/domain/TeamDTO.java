package com.microservice.development.team.domain;

import com.microservice.development.role.domain.RoleDTO;
import com.microservice.development.user.domain.UserDTO;

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
