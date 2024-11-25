package com.dmx.administrative.project.domain;

import com.dmx.administrative.card.domain.Card;
import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.ProjectId;
import com.dmx.administrative.team.domain.Team;

public abstract class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;
    private final ProjectCreateBy createBy;
    private final ProjectCreationDate creationDate;
    private final ProjectFuncionalitiesCounter funcionalitiesCounter;
    private final ProjectCardCounter cardCounter;
    private final ProjectTeamsCounter teamsCounter;
    private final Team[] teamList;
    private final Card[] cardList;

    public Project(
            ProjectId id,
            ProjectName name,
            ProjectCreateBy createBy,
            ProjectCreationDate creationDate,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            ProjectCardCounter cardCounter,
            ProjectTeamsCounter teamsCounter,
            Team[] teamList,
            Card[] cardList
    ) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.creationDate = creationDate;
        this.funcionalitiesCounter = funcionalitiesCounter;
        this.cardCounter = cardCounter;
        this.teamsCounter = teamsCounter;
        this.teamList = teamList;
        this.cardList = cardList;
    }

    public ProjectId getId() {
        return this.id;
    }

    public ProjectName getName() {
        return this.name;
    }

    public ProjectCreationDate getCreationDate() {
        return this.creationDate;
    }

    public ProjectCreateBy getCreateBy() {
        return this.createBy;
    }

    public Team[] getTeamList() {
        return this.teamList;
    }

    public ProjectFuncionalitiesCounter getFuncionalitiesCounter() {
        return this.funcionalitiesCounter;
    }

    public Card[] getCardList() {
        return this.cardList;
    }

    public ProjectCardCounter getCardCounter() {
        return this.cardCounter;
    }

    public ProjectTeamsCounter getTeamsCounter() {
        return this.teamsCounter;
    }
}
