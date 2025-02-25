package com.microservice.development.project.domain;

import java.util.HashMap;

import com.microservice.development.card.domain.CardDTO;
import com.microservice.development.team.domain.TeamDTO;

public record ProjectFuncionalitiesContainerDTO(
        String id,
        String name,
        int funcionalitiesCounter,
        HashMap<String, TeamDTO> teamsList,
        HashMap<String, CardDTO> cardList
) {
}
