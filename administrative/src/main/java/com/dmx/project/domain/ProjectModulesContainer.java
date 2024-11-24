package com.dmx.project.domain;

import com.dmx.card.domain.Card;
import com.dmx.card.domain.CardDTO;
import com.dmx.module.domain.ModuleDTO;
import com.dmx.shared.domain.ProjectId;
import com.dmx.team.domain.Team;
import com.dmx.team.domain.TeamDTO;
import com.dmx.module.domain.Module;

public final class ProjectModulesContainer extends Project {
    private final Module[] moduleList;
    private final ProjectModulesCounter modulesCounter;
    private final ProjectState state;

    public ProjectModulesContainer(
            ProjectId id,
            ProjectName name,
            ProjectCreateBy createBy,
            ProjectCreationDate creationDate,
            ProjectState state,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            Team[] teamList,
            Card[] cardList,
            Module[] moduleList
    ) {
        super(
                id,
                name,
                createBy,
                creationDate,
                funcionalitiesCounter,
                new ProjectCardCounter(cardList.length),
                new ProjectTeamsCounter(teamList.length),
                teamList,
                cardList
        );
        this.moduleList = moduleList;
        this.modulesCounter= new ProjectModulesCounter(moduleList.length);
        this.state = state;
    }

    public static ProjectModulesContainer fromPrimitives(ProjectModulesContainerDTO data) {
        Team[] teamList = new Team[data.teamsList().length];
        for (int teamsCounter = 0; teamsCounter < data.teamsList().length; teamsCounter++) {
            TeamDTO currentTeam = data.teamsList()[teamsCounter];
            teamList[teamsCounter] = Team.fromPrimitives(currentTeam);
        }

        Card[] cardList = new Card[data.cardList().length];
        for (int cardCounter = 0; cardCounter < data.cardList().length; cardCounter++) {
            CardDTO currentCard = data.cardList()[cardCounter];
            cardList[cardCounter] = Card.fromPrimitives(currentCard);
        }

        Module[] moduleList = new Module[data.moduleList().length];
        for(int moduleCounter= 0; moduleCounter<data.moduleList().length; moduleCounter++){
            ModuleDTO currentModule = data.moduleList()[moduleCounter];
            moduleList[moduleCounter] = Module.fromPrimitives(currentModule);
        }

        return new ProjectModulesContainer(
                new ProjectId(data.id()),
                new ProjectName(data.name()),
                new ProjectCreateBy(data.createBy()),
                new ProjectCreationDate(data.creationDate()),
                new ProjectState(data.state()),
                new ProjectFuncionalitiesCounter(data.funcionalitiesCounter()),
                teamList,
                cardList,
                moduleList
        );
    }

    public ProjectModulesContainerDTO toPrimitives() {
        TeamDTO[] teamsList = new TeamDTO[this.getTeamList().length];
        for (int teamsCounter = 0; teamsCounter < this.getTeamList().length; teamsCounter++) {
            teamsList[teamsCounter] = this.getTeamList()[teamsCounter].toPrimitives();
        }

        CardDTO[] cardList = new CardDTO[this.getCardList().length];
        for (int cardCounter = 0; cardCounter < this.getCardList().length; cardCounter++) {
            cardList[cardCounter] = this.getCardList()[cardCounter].toPrimitives();
        }

        ModuleDTO[] moduleList = new ModuleDTO[this.moduleList.length];
        for (int moduleCounter = 0; moduleCounter < this.moduleList.length; moduleCounter++) {
            cardList[moduleCounter] = this.getCardList()[moduleCounter].toPrimitives();
        }
        return new ProjectModulesContainerDTO(
                this.getId().value(),
                this.getName().value(),
                this.getCreateBy().value(),
                this.getCreationDate().value(),
                this.state.value(),
                this.getFuncionalitiesCounter().value(),
                teamsList,
                cardList,
                moduleList
        );
    }

    public Module[] getModuleList() {
        return this.moduleList;
    }

    public ProjectModulesCounter getModulesCounter() {
        return this.modulesCounter;
    }

    public ProjectState getState() {
        return this.state;
    }
}
