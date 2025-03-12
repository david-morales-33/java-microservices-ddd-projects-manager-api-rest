package com.microservice.administrative.project.application.findModuleProject;

import com.microservice.administrative.card.domain.Card;
import com.microservice.administrative.card.domain.CardTest;
import com.microservice.administrative.module.domain.Module;
import com.microservice.administrative.module.domain.ModuleTest;
import com.microservice.administrative.project.domain.*;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.team.domain.Team;
import com.microservice.administrative.team.domain.TeamTest;

import java.util.HashMap;

public final class ProjectResponseTest {
    public static ProjectResponse create(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList,
            HashMap<Integer, Module> moduleList
    ) {
        return new ProjectResponse(new ProjectModulesContainer(id, name, funcionalitiesCounter, teamList, cardList, moduleList).toPrimitives());
    }

    public static ProjectResponse random() {
        HashMap<String, Team> teamList = new HashMap<>();
        HashMap<String, Card> cardList = new HashMap<>();
        HashMap<Integer, Module> moduleList = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            Team team = TeamTest.random();
            Card card = CardTest.random();
            Module module = ModuleTest.random();
            teamList.put(team.getId().value(), team);
            cardList.put(card.getId().value(), card);
            moduleList.put(module.getId().value(), module);
        }
        return create(ProjectIdTest.random(), ProjectNameTest.random(), ProjectFuncionalitiesCounterTest.random(), teamList, cardList, moduleList);
    }
}
