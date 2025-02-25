package com.microservice.development.project.domain;

import java.util.HashMap;

import com.microservice.development.card.domain.CardDTO;
import com.microservice.development.module.domain.ModuleDTO;
import com.microservice.development.team.domain.TeamDTO;

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
