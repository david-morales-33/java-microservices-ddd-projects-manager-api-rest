package com.microservice.media.space.domain;

import java.util.HashMap;
import java.util.HashSet;

import com.microservice.media.post.domain.PostDTO;

public record SpaceDTO(
        String id,
        String name,
        String creationDate,
        String createBy,
        HashMap<String, PostDTO> postList,
        HashSet<String> memberList,
        int postCounter,
        int membersCounter
) {
}
