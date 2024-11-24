package com.dmx.project.domain;

import com.dmx.card.domain.CardDTO;
import com.dmx.team.domain.TeamDTO;

public record ProjectFuncionalitiesContainerDTO(
        String id,
        String name,
        String createBy,
        String creationDate,
        int funcionalitiesCounter,
        TeamDTO[] teamsList,
        CardDTO[] cardList
) {
}
