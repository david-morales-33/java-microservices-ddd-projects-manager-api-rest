package com.dmx.team.domain;

import com.dmx.space.domain.SpaceDTO;

public record TeamDTO(
        String id,
        String name,
        int membersCounter,
        int spacesCounter,
        String creationDate,
        boolean state,
        String[] memberList,
        SpaceDTO[] spaceList
) {
}
