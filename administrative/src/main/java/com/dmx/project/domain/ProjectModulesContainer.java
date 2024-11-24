package com.dmx.project.domain;

import com.dmx.shared.domain.ProjectId;
import com.dmx.team.domain.Team;
import com.dmx.team.domain.TeamDTO;

public final class ProjectModulesContainer extends Project {
    private final ProjectModulesCounter modulesCounter;
    private final ProjectState state;
    private final ProjectFuncionalitiesCounter funcionalitiesCounter;
    private final Team[] teamList;

    public ProjectModulesContainer(
            ProjectId id,
            ProjectName name,
            ProjectCreateBy createBy,
            ProjectCreationDate creationDate,
            ProjectModulesCounter modulesCounter,
            ProjectState state,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            Team[] teamsList
    ) {
        super(id, name, createBy, creationDate);
        this.modulesCounter = modulesCounter;
        this.state = state;
        this.funcionalitiesCounter = funcionalitiesCounter;
        this.teamList = teamsList;
    }

    public static ProjectModulesContainer fromPrimitives(ProjectModulesContainerDTO data){
        Team[] teamList = new Team[data.teamsList().length];
        for(int teamsCounter= 0 ; teamsCounter<data.teamsList().length; teamsCounter++){
            TeamDTO currentTeam = data.teamsList()[teamsCounter];
            teamList[teamsCounter] = Team.fromPrimitives(currentTeam);
        }
        return new ProjectModulesContainer(
                new ProjectId(data.id()),
                new ProjectName(data.name()),
                new ProjectCreateBy(data.createBy()),
                new ProjectCreationDate(data.creationDate()),
                new ProjectModulesCounter(data.modulesCounter()),
                new ProjectState(data.state()),
                new ProjectFuncionalitiesCounter(data.funcionalitiesCounter()),
                teamList
        );
    }

    public ProjectModulesContainerDTO toPrimitives(){
        TeamDTO[] teamsList = new TeamDTO[this.teamList.length];
        for(int teamsCounter = 0; teamsCounter<this.teamList.length; teamsCounter++){
            teamsList[teamsCounter] = this.teamList[teamsCounter].toPrimitives();
        }
        return new ProjectModulesContainerDTO(
                this.getId().value(),
                this.getName().value(),
                this.getCreateBy().value(),
                this.getCreationDate().value(),
                this.modulesCounter.value(),
                this.state.value(),
                this.funcionalitiesCounter.value(),
                teamsList
        );
    }

    public ProjectModulesCounter getModulesCounter() {
        return this.modulesCounter;
    }

    public ProjectState getState() {
        return this.state;
    }

    public ProjectFuncionalitiesCounter getFuncionalitiesCounter() {
        return this.funcionalitiesCounter;
    }

    public Team[] getTeamsList() {
        return teamList;
    }
}
