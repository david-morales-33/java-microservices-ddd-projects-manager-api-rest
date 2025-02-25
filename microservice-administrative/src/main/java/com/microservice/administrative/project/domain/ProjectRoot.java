package com.microservice.administrative.project.domain;

import java.util.HashMap;

import com.microservice.administrative.card.domain.Card;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.team.domain.Team;

public final class ProjectRoot extends Project{
    public ProjectRoot(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList
    ) {
        super(id, name, funcionalitiesCounter, teamList, cardList);
    }
}
