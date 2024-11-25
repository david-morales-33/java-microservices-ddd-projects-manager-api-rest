package com.dmx.administrative.project.domain;

import com.dmx.administrative.card.domain.CardDTO;
import com.dmx.administrative.team.domain.TeamDTO;

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
