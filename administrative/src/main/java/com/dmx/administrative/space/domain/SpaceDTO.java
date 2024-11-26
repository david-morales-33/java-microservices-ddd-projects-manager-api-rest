package com.dmx.administrative.space.domain;

import java.util.HashSet;

public record SpaceDTO(
        String id,
        String name,
        String creationDate,
        String createBy,
        HashSet<String> postList,
        HashSet<String> memberList) {
}
