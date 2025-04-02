package com.microservice.media.space.domain;

import java.util.HashMap;
import java.util.HashSet;

import com.microservice.media.post.domain.PostDTO;
import com.microservice.media.user.domain.UserDTO;

public record SpaceDTO(
        String id,
        String name,
        String creationDate,
        String createBy,
        HashMap<String, PostDTO> postList,
        HashSet<UserDTO> memberList,
        int postCounter,
        int membersCounter
) {
}
