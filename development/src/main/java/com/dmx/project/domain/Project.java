package com.dmx.project.domain;

import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.ProjectId;

public final class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;

    public Project(ProjectId id, ProjectName name) {
        this.id = id;
        this.name = name;
    }

    public static Project create(ProjectId id, ProjectName name) {
        return new Project(id, name);
    }

    public ProjectId getId() {
        return this.id;
    }

    public ProjectName getName() {
        return this.name;
    }

    public static Project fromPrimitives(String id, String name, int projectTypeId, String projectTypeName) {
        return new Project(
                new ProjectId(id),
                new ProjectName(name)
        );
    }
}
