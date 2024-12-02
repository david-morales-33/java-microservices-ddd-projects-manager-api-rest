package com.dmx.administrative.project.domain;

import com.dmx.administrative.card.domain.CardDTO;
import com.dmx.administrative.team.domain.TeamDTO;

import java.util.HashMap;

public record ProjectFuncionalitiesContainerDTO(
        String id,
        String name,
        int funcionalitiesCounter,
        HashMap<String, TeamDTO> teamsList,
        HashMap<String, CardDTO> cardList
) {
}
