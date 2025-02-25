package com.microservice.administrative.team.domain;

import com.microservice.administrative.role.domain.RoleDTO;
import com.microservice.administrative.user.domain.UserDTO;

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
