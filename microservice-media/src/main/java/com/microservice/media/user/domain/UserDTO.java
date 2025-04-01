package com.microservice.media.user.domain;


import com.microservice.media.role.domain.RoleDTO;

import java.util.HashMap;
import java.util.Map;

public record UserDTO(
        String id,
        String name,
        String email,
        String nickName,
        Map<String, RoleDTO> roleList
) {
}
