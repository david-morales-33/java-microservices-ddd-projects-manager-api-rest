package com.dmx.administrative.user.domain;

import com.dmx.administrative.role.domain.RoleDTO;

public record UserDTO(String id, String name, String email, String nickName, RoleDTO role) {
}
