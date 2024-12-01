package com.dmx.media.user.domain;


import com.dmx.media.role.domain.RoleDTO;

import java.util.HashMap;

public record UserDTO(
        String id,
        String name,
        String email,
        String nickName,
        HashMap<String, RoleDTO> roleList
) {
}
