package com.microservice.development.project.domain;

import java.util.HashMap;

import com.microservice.development.card.domain.Card;
import com.microservice.development.card.domain.CardDTO;
import com.microservice.development.shared.domain.ProjectId;
import com.microservice.development.team.domain.Team;
import com.microservice.development.team.domain.TeamDTO;

public final class ProjectFuncionalitiesContainer extends Project {
    public ProjectFuncionalitiesContainer(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList
    ) {
        super(id, name, funcionalitiesCounter, teamList, cardList);
    }

    public static ProjectFuncionalitiesContainer create(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList
    ) {
        return new ProjectFuncionalitiesContainer(id, name, funcionalitiesCounter, teamList, cardList);
    }

    public static ProjectFuncionalitiesContainer fromPrimitives(ProjectModulesContainerDTO data) {
        HashMap<String, Team> teamList = new HashMap<>();
        HashMap<String, Card> cardList = new HashMap<>();

        data.teamsList().forEach((key, value) -> {
            teamList.put(key, Team.fromPrimitives(value));
        });
        data.cardList().forEach((key, value) -> {
            cardList.put(key, Card.fromPrimitives(value));
        });
        return new ProjectFuncionalitiesContainer(
                new ProjectId(data.id()),
                new ProjectName(data.name()),
                new ProjectFuncionalitiesCounter(data.funcionalitiesCounter()),
                teamList,
                cardList
        );
    }

    public ProjectFuncionalitiesContainerDTO toPrimitives() {
        HashMap<String, TeamDTO> teamList = new HashMap<>();
        HashMap<String, CardDTO> cardList = new HashMap<>();

        this.getTeamList().forEach((key, value) -> {
            teamList.put(key, value.toPrimitives());
        });
        this.getCardList().forEach((key, value) -> {
            cardList.put(key, value.toPrimitives());
        });

        return new ProjectFuncionalitiesContainerDTO(
                this.getId().value(),
                this.getName().value(),
                this.getFuncionalitiesCounter().value(),
                teamList,
                cardList
        );
    }

}
