package com.dmx.project.domain;

import com.dmx.card.domain.Card;
import com.dmx.card.domain.CardDTO;
import com.dmx.shared.domain.ProjectId;
import com.dmx.team.domain.Team;
import com.dmx.team.domain.TeamDTO;

public class ProjectFuncionalitiesContainer extends Project {
    public ProjectFuncionalitiesContainer(
            ProjectId id,
            ProjectName name,
            ProjectCreateBy createBy,
            ProjectCreationDate creationDate,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            Team[] teamList,
            Card[] cardList
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
    }

    public static ProjectFuncionalitiesContainer fromPrimitives(ProjectFuncionalitiesContainerDTO data) {
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

        return new ProjectFuncionalitiesContainer(
                new ProjectId(data.id()),
                new ProjectName(data.name()),
                new ProjectCreateBy(data.createBy()),
                new ProjectCreationDate(data.creationDate()),
                new ProjectFuncionalitiesCounter(data.funcionalitiesCounter()),
                teamList,
                cardList
        );
    }

    public ProjectFuncionalitiesContainerDTO toPrimitives() {
        TeamDTO[] teamsList = new TeamDTO[this.getTeamList().length];
        for (int teamsCounter = 0; teamsCounter < this.getTeamList().length; teamsCounter++) {
            teamsList[teamsCounter] = this.getTeamList()[teamsCounter].toPrimitives();
        }

        CardDTO[] cardList = new CardDTO[this.getCardList().length];
        for (int cardCounter = 0; cardCounter < this.getCardList().length; cardCounter++) {
            cardList[cardCounter] = this.getCardList()[cardCounter].toPrimitives();
        }

        return new ProjectFuncionalitiesContainerDTO(
                this.getId().value(),
                this.getName().value(),
                this.getCreateBy().value(),
                this.getCreationDate().value(),
                this.getFuncionalitiesCounter().value(),
                teamsList,
                cardList
        );
    }
}
