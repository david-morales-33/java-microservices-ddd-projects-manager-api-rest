package com.dmx.administrative.project.application.findFuncionalityProject;

import com.dmx.administrative.project.domain.ProjectFuncionalitiesContainerDTO;
import com.dmx.administrative.shared.domain.bus.query.Response;

public final class ProjectResponse implements Response {
    private final ProjectFuncionalitiesContainerDTO response;

    public ProjectResponse(ProjectFuncionalitiesContainerDTO response) {
        this.response = response;
    }

    public ProjectFuncionalitiesContainerDTO getResponse() {
        return this.response;
    }
}
