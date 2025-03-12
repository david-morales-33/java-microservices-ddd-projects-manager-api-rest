package com.microservice.administrative.project.domain;

import java.util.HashMap;

import com.microservice.administrative.card.domain.CardDTO;
import com.microservice.administrative.module.domain.ModuleDTO;
import com.microservice.administrative.team.domain.TeamDTO;

public record ProjectModulesContainerDTO(
        String id,
        String name,
        int funcionalitiesCounter,
        float state,
        HashMap<String, TeamDTO> teamsList,
        HashMap<String, CardDTO> cardList,
        HashMap<Integer, ModuleDTO> moduleList
) {
}
