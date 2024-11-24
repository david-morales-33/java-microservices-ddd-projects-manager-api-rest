package com.dmx.project.domain;

import com.dmx.shared.domain.ProjectId;
import com.dmx.team.domain.Team;

public class ProjectFuncionalitiesContainer extends Project {
    public ProjectFuncionalitiesContainer(
            ProjectId id,
            ProjectName name,
            ProjectCreateBy createBy,
            ProjectCreationDate creationDate,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            Team[] teamList
    ) {
        super(id, name, createBy, creationDate, funcionalitiesCounter, teamList);
    }
}
