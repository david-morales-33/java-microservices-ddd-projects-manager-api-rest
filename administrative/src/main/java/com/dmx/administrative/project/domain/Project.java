package com.dmx.administrative.project.domain;

import com.dmx.administrative.card.domain.Card;
import com.dmx.administrative.team.domain.Team;
import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.ProjectId;

import java.util.HashMap;

public abstract class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;
    private final HashMap<String, Team> teamList;
    private final HashMap<String, Card> cardList;
    private ProjectFuncionalitiesCounter funcionalitiesCounter;
    private ProjectCardCounter cardCounter;
    private ProjectTeamsCounter teamsCounter;

    public Project(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList
    ) {
        this.id = id;
        this.name = name;
        this.funcionalitiesCounter = funcionalitiesCounter;
        this.teamList = teamList;
        this.cardList = cardList;
        this.teamsCounter = new ProjectTeamsCounter(teamList.size());
        this.cardCounter = new ProjectCardCounter(cardList.size());
    }

    public void incrementFuncionalitiesCounter() {
        this.funcionalitiesCounter = new ProjectFuncionalitiesCounter(this.funcionalitiesCounter.value() + 1);
    }

    public void incrementCardCounter() {
        this.cardCounter = new ProjectCardCounter(this.cardCounter.value() + 1);
    }

    public void incrementTeamsCounter() {
        this.teamsCounter = new ProjectTeamsCounter(this.teamsCounter.value() + 1);
    }

    public ProjectId getId() {
        return this.id;
    }

    public ProjectName getName() {
        return this.name;
    }

    public ProjectFuncionalitiesCounter getFuncionalitiesCounter() {
        return this.funcionalitiesCounter;
    }

    public HashMap<String, Team> getTeamList() {
        return teamList;
    }

    public HashMap<String, Card> getCardList() {
        return cardList;
    }

    public ProjectCardCounter getCardCounter() {
        return this.cardCounter;
    }

    public ProjectTeamsCounter getTeamsCounter() {
        return this.teamsCounter;
    }
}
