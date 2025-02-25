package com.microservice.development.user.domain;

import java.util.HashMap;

import com.microservice.development.role.domain.RoleDTO;

public record UserDTO(
        String id,
        String name,
        String email,
        String nickName,
        HashMap<String, RoleDTO> roleList
) {
}
