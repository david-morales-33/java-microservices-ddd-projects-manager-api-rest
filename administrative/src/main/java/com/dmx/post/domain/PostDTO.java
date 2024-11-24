package com.dmx.post.domain;

import com.dmx.user.domain.UserDTO;

public record PostDTO(String id, String title, String content, String creationDate, String spaceId, UserDTO user) {
}
