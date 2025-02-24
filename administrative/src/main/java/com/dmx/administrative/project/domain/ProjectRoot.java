package com.dmx.administrative.project.domain;

import com.dmx.administrative.card.domain.Card;
import com.dmx.administrative.shared.domain.ProjectId;
import com.dmx.administrative.team.domain.Team;

import java.util.HashMap;

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
