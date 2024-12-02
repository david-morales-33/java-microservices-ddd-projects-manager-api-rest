package com.dmx.development.project.domain;

import com.dmx.development.card.domain.CardDTO;
import com.dmx.development.module.domain.ModuleDTO;
import com.dmx.development.team.domain.TeamDTO;

import java.util.HashMap;

public record ProjectModulesContainerDTO(
        String id,
        String name,
        int funcionalitiesCounter,
        float state,
        HashMap<String, TeamDTO> teamsList,
        HashMap<String, CardDTO> cardList,
        HashMap<String, ModuleDTO> moduleList
) {
}
