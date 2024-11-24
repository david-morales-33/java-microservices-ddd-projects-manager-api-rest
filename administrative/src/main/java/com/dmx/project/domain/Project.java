package com.dmx.project.domain;

import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.ProjectId;

public abstract class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;
    private final ProjectCreateBy createBy;
    private final ProjectCreationDate creationDate;

    public Project(
            ProjectId id,
            ProjectName name,
            ProjectCreateBy createBy,
            ProjectCreationDate creationDate
    ) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.creationDate = creationDate;
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
}
