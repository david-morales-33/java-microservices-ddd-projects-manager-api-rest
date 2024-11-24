package com.dmx.project.domain;

import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.ProjectId;
import com.dmx.team.domain.Team;

public abstract class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;
    private final ProjectCreateBy createBy;
    private final ProjectCreationDate creationDate;
    private final ProjectFuncionalitiesCounter funcionalitiesCounter;
    private final Team[] teamList;

    public Project(
            ProjectId id,
            ProjectName name,
            ProjectCreateBy createBy,
            ProjectCreationDate creationDate,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            Team[] teamList
    ) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.creationDate = creationDate;
        this.funcionalitiesCounter = funcionalitiesCounter;
        this.teamList = teamList;
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
}
