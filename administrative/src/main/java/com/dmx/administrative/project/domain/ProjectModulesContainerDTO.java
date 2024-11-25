package com.dmx.administrative.project.domain;

import com.dmx.administrative.card.domain.CardDTO;
import com.dmx.administrative.module.domain.ModuleDTO;
import com.dmx.administrative.team.domain.TeamDTO;

public record ProjectModulesContainerDTO(
        String id,
        String name,
        String createBy,
        String creationDate,
        float state,
        int funcionalitiesCounter,
        TeamDTO[] teamsList,
        CardDTO[] cardList,
        ModuleDTO[] moduleList
) {
}
