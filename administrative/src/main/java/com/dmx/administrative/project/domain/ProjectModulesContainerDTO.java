package com.dmx.administrative.project.domain;

import com.dmx.administrative.card.domain.CardDTO;
import com.dmx.administrative.module.domain.ModuleDTO;
import com.dmx.administrative.team.domain.TeamDTO;

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
