package com.microservice.development.project.domain;

import java.util.HashMap;

import com.microservice.development.card.domain.Card;
import com.microservice.development.shared.domain.AggregateRoot;
import com.microservice.development.shared.domain.ProjectId;
import com.microservice.development.team.domain.Team;

public abstract class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;
    private final ProjectFuncionalitiesCounter funcionalitiesCounter;
    private final ProjectCardCounter cardCounter;
    private final ProjectTeamsCounter teamsCounter;
    private final HashMap<String, Team> teamList;
    private final HashMap<String, Card> cardList;

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

    public ProjectId getId() {
        return this.id;
    }

    public ProjectName getName() {
        return this.name;
    }

    public ProjectFuncionalitiesCounter getFuncionalitiesCounter() {
        return this.funcionalitiesCounter;
    }

    public HashMap<String, Team> getTeamList() { return teamList; }

    public HashMap<String, Card> getCardList() { return cardList; }

    public ProjectCardCounter getCardCounter() {
        return this.cardCounter;
    }

    public ProjectTeamsCounter getTeamsCounter() {
        return this.teamsCounter;
    }
}
