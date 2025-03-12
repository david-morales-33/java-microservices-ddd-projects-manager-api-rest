package com.microservice.administrative.project.domain;

import com.microservice.administrative.card.domain.Card;
import com.microservice.administrative.card.domain.CardTest;
import com.microservice.administrative.funcionality.domain.Funcionality;
import com.microservice.administrative.funcionality.domain.FuncionalityTest;
import com.microservice.administrative.project.application.createModuleProject.CreateProjectCommand;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamTest;

import java.util.HashMap;

public final class ProjectFuncionalitiesContainerTest {
    public static ProjectFuncionalitiesContainer create(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList,
            HashMap<Integer, Funcionality> funcionalityList
    ) {
        return new ProjectFuncionalitiesContainer(id, name, funcionalitiesCounter, teamList, cardList, funcionalityList);
    }

    public static ProjectFuncionalitiesContainer fromRequest(CreateProjectCommand command) {
        return ProjectFuncionalitiesContainer.create(
                new ProjectId(command.getId()),
                new ProjectName(command.getName()),
                new ProjectFuncionalitiesCounter(0)
        );
    }

    public static ProjectFuncionalitiesContainer random() {
        HashMap<String, Team> teamList = new HashMap<>();
        HashMap<String, Card> cardList = new HashMap<>();
        HashMap<Integer, Funcionality> funcionalityList = new HashMap<>();

        for (int i = 0; i < 2; i++) {
            Team team = TeamTest.random();
            teamList.put(team.getId().value(), team);
        }
        for (int i = 0; i < 4; i++) {
            Card card = CardTest.random();
            cardList.put(card.getId().value(), card);
        }
        for (int i = 0; i < 2; i++) {
            Funcionality funcionality = FuncionalityTest.random();
            funcionalityList.put(funcionality.getId().value(), funcionality);
        }
        return create(
                ProjectIdTest.random(),
                ProjectNameTest.random(),
                ProjectFuncionalitiesCounterTest.random(),
                teamList,
                cardList,
                funcionalityList
        );
    }
}
