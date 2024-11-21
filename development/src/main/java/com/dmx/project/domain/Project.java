package com.dmx.project.domain;

import com.dmx.projectType.domain.ProjectType;
import com.dmx.projectType.domain.ProjectTypeName;
import com.dmx.shared.domain.AggregateRoot;
import com.dmx.shared.domain.ProjectId;
import com.dmx.shared.domain.ProjectTypeId;

public final class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;
    private final ProjectType type;

    public Project(ProjectId id, ProjectName name, ProjectType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public static Project create(ProjectId id, ProjectName name, ProjectType typeId) {
        return new Project(id, name, typeId);
    }

    public ProjectId getId() {
        return this.id;
    }

    public ProjectName getName() {
        return this.name;
    }

    public ProjectType getTypeId() {
        return this.type;
    }

    public static Project fromPrimitives(String id, String name, int projectTypeId, String projectTypeName) {
        return new Project(
                new ProjectId(id),
                new ProjectName(name),
                new ProjectType(
                        new ProjectTypeId(projectTypeId),
                        new ProjectTypeName(projectTypeName)
                )
        );
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name=" + name +
                ", type=" + type +
                '}';
    }
}
