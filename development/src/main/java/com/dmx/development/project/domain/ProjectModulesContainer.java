package com.dmx.development.project.domain;

import com.dmx.development.card.domain.Card;
import com.dmx.development.card.domain.CardDTO;
import com.dmx.development.module.domain.ModuleDTO;
import com.dmx.development.team.domain.TeamDTO;
import com.dmx.shared.domain.ProjectId;
import com.dmx.development.team.domain.Team;
import com.dmx.development.module.domain.Module;

import java.util.HashMap;

public final class ProjectModulesContainer extends Project {
    private final HashMap<String, Module> moduleList;
    private final ProjectModulesCounter modulesCounter;
    private final ProjectState state;

    public ProjectModulesContainer(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList,
            HashMap<String, Module> moduleList
    ) {
        super(id, name, funcionalitiesCounter, teamList, cardList);
        this.moduleList = moduleList;
        this.modulesCounter = new ProjectModulesCounter(moduleList.size());
        this.state = new ProjectState(0);
    }

    public static ProjectModulesContainer create(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList,
            HashMap<String, Module> moduleList
    ) {
        return new ProjectModulesContainer(id, name, funcionalitiesCounter, teamList, cardList, moduleList);
    }

    public static ProjectModulesContainer fromPrimitives(ProjectModulesContainerDTO data) {
        HashMap<String, Team> teamList = new HashMap<>();
        HashMap<String, Card> cardList = new HashMap<>();
        HashMap<String, Module> moduleList = new HashMap<>();

        data.teamsList().forEach((key, value) -> {
            teamList.put(key, Team.fromPrimitives(value));
        });
        data.cardList().forEach((key, value) -> {
            cardList.put(key, Card.fromPrimitives(value));
        });
        data.moduleList().forEach((key, value) -> {
            moduleList.put(key, Module.fromPrimitives(value));
        });

        return new ProjectModulesContainer(
                new ProjectId(data.id()),
                new ProjectName(data.name()),
                new ProjectFuncionalitiesCounter(data.funcionalitiesCounter()),
                teamList,
                cardList,
                moduleList
        );
    }

    public ProjectModulesContainerDTO toPrimitives() {
        HashMap<String, TeamDTO> teamList = new HashMap<>();
        HashMap<String, CardDTO> cardList = new HashMap<>();
        HashMap<String, ModuleDTO> moduleList = new HashMap<>();

        this.getTeamList().forEach((key, value) -> {
            teamList.put(key, value.toPrimitives());
        });
        this.getCardList().forEach((key, value) -> {
            cardList.put(key, value.toPrimitives());
        });
        this.moduleList.forEach((key, value) -> {
            moduleList.put(key, value.toPrimitives());
        });

        return new ProjectModulesContainerDTO(
                this.getId().value(),
                this.getName().value(),
                this.getFuncionalitiesCounter().value(),
                this.state.value(),
                teamList,
                cardList,
                moduleList
        );
    }

    public HashMap<String, Module> getModuleList() {
        return moduleList;
    }

    public ProjectModulesCounter getModulesCounter() {
        return modulesCounter;
    }

    public ProjectState getState() {
        return state;
    }
}
