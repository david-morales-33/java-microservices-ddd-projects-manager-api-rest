package com.dmx.administrative.space.domain;

import com.dmx.administrative.post.domain.PostDTO;

import java.util.HashMap;
import java.util.HashSet;

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
