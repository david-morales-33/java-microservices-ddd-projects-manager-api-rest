package com.dmx.administrative.project.domain;

import com.dmx.administrative.card.domain.Card;
import com.dmx.administrative.card.domain.CardDTO;
import com.dmx.administrative.funcionality.domain.Funcionality;
import com.dmx.administrative.funcionality.domain.FuncionalityDTO;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamDTO;
import com.dmx.shared.domain.ProjectId;

import java.util.HashMap;

public final class ProjectFuncionalitiesContainer extends Project {

    private final HashMap<String, Funcionality> funcionalityList;

    public ProjectFuncionalitiesContainer(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList,
            HashMap<String, Funcionality> funcionalityList
    ) {
        super(id, name, funcionalitiesCounter, teamList, cardList);
        this.funcionalityList = funcionalityList;
    }

    public static ProjectFuncionalitiesContainer create(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList,
            HashMap<String, Funcionality> funcionalityList
    ) {
        return new ProjectFuncionalitiesContainer(id, name, funcionalitiesCounter, teamList, cardList, funcionalityList);
    }

    public static ProjectFuncionalitiesContainer fromPrimitives(ProjectFuncionalitiesContainerDTO data) {
        HashMap<String, Team> teamList = new HashMap<>();
        HashMap<String, Card> cardList = new HashMap<>();
        HashMap<String, Funcionality> funcionalityList = new HashMap<>();

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
        HashMap<String, FuncionalityDTO> funcionalityList = new HashMap<>();

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
        this.funcionalityList.put(funcionality.getId().value().toString(), funcionality);
        this.incrementFuncionalitiesCounter();
    }

    public HashMap<String, Funcionality> getFuncionalityList() {
        return this.funcionalityList;
    }
}
