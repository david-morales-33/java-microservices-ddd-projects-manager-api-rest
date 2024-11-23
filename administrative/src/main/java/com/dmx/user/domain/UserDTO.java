package com.dmx.user.domain;

import com.dmx.role.domain.RoleDTO;

public record UserDTO(String id, String name, String email, String nickName, RoleDTO role) {
}
