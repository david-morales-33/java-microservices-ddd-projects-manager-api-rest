package com.dmx.administrative.project.application.createModuleProject;

import com.dmx.administrative.project.domain.ProjectName;
import com.dmx.shared.domain.ProjectId;
import com.dmx.shared.domain.bus.command.Command;

public final class CreateProjectCommand implements Command {
    private final ProjectId id;
    private final ProjectName name;

    public CreateProjectCommand(ProjectId id, ProjectName name) {
        this.id = id;
        this.name = name;
    }

    public ProjectId getId() {
        return this.id;
    }

    public ProjectName getName() {
        return this.name;
    }
}
