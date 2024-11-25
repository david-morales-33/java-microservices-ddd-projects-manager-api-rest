package com.dmx.administrative.post.domain;

import com.dmx.administrative.user.domain.UserDTO;

public record PostDTO(String id, String title, String content, String creationDate, String spaceId, UserDTO user) {
}
