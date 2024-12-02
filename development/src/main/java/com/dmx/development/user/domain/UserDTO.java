package com.dmx.development.user.domain;

import com.dmx.development.role.domain.RoleDTO;

import java.util.HashMap;

public record UserDTO(
        String id,
        String name,
        String email,
        String nickName,
        HashMap<String, RoleDTO> roleList
) {
}
