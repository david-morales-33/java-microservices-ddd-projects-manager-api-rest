package com.dmx.administrative.space.domain;

public record SpaceDTO(
        String id,
        String name,
        String creationDate,
        String createBy,
        String[] postList,
        String[] memberList) {
}
