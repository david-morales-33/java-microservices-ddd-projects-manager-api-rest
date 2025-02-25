package com.microservice.administrative.project.domain;

import com.microservice.administrative.card.domain.CardDTO;
import com.microservice.administrative.funcionality.domain.FuncionalityDTO;
import com.microservice.administrative.team.domain.TeamDTO;

import java.util.HashMap;

public record ProjectFuncionalitiesContainerDTO(
        String id,
        String name,
        int funcionalitiesCounter,
        HashMap<String, TeamDTO> teamsList,
        HashMap<String, CardDTO> cardList,
        HashMap<String, FuncionalityDTO> funcionalityList
) {
}
