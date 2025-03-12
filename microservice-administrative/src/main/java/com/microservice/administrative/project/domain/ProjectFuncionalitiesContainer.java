package com.microservice.administrative.project.domain;

import com.microservice.administrative.card.domain.Card;
import com.microservice.administrative.card.domain.CardDTO;
import com.microservice.administrative.funcionality.domain.Funcionality;
import com.microservice.administrative.funcionality.domain.FuncionalityDTO;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamDTO;

import java.util.HashMap;

public final class ProjectFuncionalitiesContainer extends Project {

    private final HashMap<Integer, Funcionality> funcionalityList;

    public ProjectFuncionalitiesContainer(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList,
            HashMap<Integer, Funcionality> funcionalityList
    ) {
        super(id, name, funcionalitiesCounter, teamList, cardList);
        this.funcionalityList = funcionalityList;
    }

    public static ProjectFuncionalitiesContainer create(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter
    ) {
        return new ProjectFuncionalitiesContainer(id, name, funcionalitiesCounter, new HashMap<>(), new HashMap<>(), new HashMap<>());
    }

    public static ProjectFuncionalitiesContainer fromPrimitives(ProjectFuncionalitiesContainerDTO data) {
        HashMap<String, Team> teamList = new HashMap<>();
        HashMap<String, Card> cardList = new HashMap<>();
        HashMap<Integer, Funcionality> funcionalityList = new HashMap<>();

        data.teamsList().forEach((key, value) -> {
            teamList.put(key, Team.fromPrimitives(value));
        });
        data.cardList().forEach((key, value) -> {
            cardList.put(key, Card.fromPrimitives(value));
        });
        data.funcionalityList().forEach((key, value) -> {
            funcionalityList.put(key, Funcionality.fromPrimitives(value));
        });
        return new ProjectFuncionalitiesContainer(
                new ProjectId(data.id()),
                new ProjectName(data.name()),
                new ProjectFuncionalitiesCounter(data.funcionalitiesCounter()),
                teamList,
                cardList,
                funcionalityList
        );
    }

    public ProjectFuncionalitiesContainerDTO toPrimitives() {
        HashMap<String, TeamDTO> teamList = new HashMap<>();
        HashMap<String, CardDTO> cardList = new HashMap<>();
        HashMap<Integer, FuncionalityDTO> funcionalityList = new HashMap<>();

        this.getTeamList().forEach((key, value) -> {
            teamList.put(key, value.toPrimitives());
        });
        this.getCardList().forEach((key, value) -> {
            cardList.put(key, value.toPrimitives());
        });
        this.funcionalityList.forEach((key, value) -> {
            funcionalityList.put(key, value.toPrimitives());
        });

        return new ProjectFuncionalitiesContainerDTO(
                this.getId().value(),
                this.getName().value(),
                this.getFuncionalitiesCounter().value(),
                teamList,
                cardList,
                funcionalityList
        );
    }

    public void addFuncionality(Funcionality funcionality) {
        this.funcionalityList.put(funcionality.getId().value(), funcionality);
        this.incrementFuncionalitiesCounter();
    }

    public HashMap<Integer, Funcionality> getFuncionalityList() {
        return this.funcionalityList;
    }
}
