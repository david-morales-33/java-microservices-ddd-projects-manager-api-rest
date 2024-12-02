package com.dmx.media.post.domain;


import com.dmx.media.user.domain.UserDTO;

public record PostDTO(String id, String title, String content, String creationDate, String spaceId, UserDTO user) {
}
