package com.microservice.administrative.project.domain;

import com.microservice.administrative.card.domain.Card;
import com.microservice.administrative.card.domain.CardTest;
import com.microservice.administrative.project.application.createModuleProject.CreateProjectCommand;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamTest;

import java.util.HashMap;

public final class ProjectRootTest {
    public static ProjectRoot create(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList
    ) {
        return new ProjectRoot(id, name, funcionalitiesCounter, teamList, cardList);
    }

    public static ProjectRoot fromRequest(CreateProjectCommand command) {
        return create(
                ProjectIdTest.create(command.getId()),
                ProjectNameTest.create(command.getName()),
                ProjectFuncionalitiesCounterTest.create(0),
                new HashMap<>(),
                new HashMap<>()
        );
    }

    public static ProjectRoot random() {
        HashMap<String, Team> teamList = new HashMap<>();
        HashMap<String, Card> cardList = new HashMap<>();

        for (int i = 0; i < 2; i++) {
            Team team = TeamTest.random();
            teamList.put(team.getId().value(), team);
        }
        for (int i = 0; i < 4; i++) {
            Card card = CardTest.random();
            cardList.put(card.getId().value(), card);
        }
        return create(
                ProjectIdTest.random(),
                ProjectNameTest.random(),
                ProjectFuncionalitiesCounterTest.random(),
                teamList,
                cardList
        );
    }
}
