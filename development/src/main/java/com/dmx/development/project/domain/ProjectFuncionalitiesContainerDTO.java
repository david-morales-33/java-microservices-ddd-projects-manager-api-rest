package com.dmx.development.project.domain;

import com.dmx.development.card.domain.CardDTO;
import com.dmx.development.team.domain.TeamDTO;

import java.util.HashMap;

public record ProjectFuncionalitiesContainerDTO(
        String id,
        String name,
        int funcionalitiesCounter,
        HashMap<String, TeamDTO> teamsList,
        HashMap<String, CardDTO> cardList
) {
}
