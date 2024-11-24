package com.dmx.project.domain;

import com.dmx.team.domain.TeamDTO;

public record ProjectModulesContainerDTO(
        String id,
        String name,
        String createBy,
        String creationDate,
        int modulesCounter,
        float state,
        int funcionalitiesCounter,
        TeamDTO[] teamsList
) {
}
