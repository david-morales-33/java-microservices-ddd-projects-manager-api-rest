package com.microservice.media.post.domain;


import com.microservice.media.user.domain.UserDTO;

public record PostDTO(String id, String title, String content, String creationDate, String spaceId, UserDTO user) {
}
