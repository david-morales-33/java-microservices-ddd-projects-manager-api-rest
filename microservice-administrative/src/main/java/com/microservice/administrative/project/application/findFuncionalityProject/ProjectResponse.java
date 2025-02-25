package com.microservice.administrative.project.application.findFuncionalityProject;

import com.microservice.administrative.project.domain.ProjectFuncionalitiesContainerDTO;
import com.microservice.administrative.shared.domain.bus.query.Response;

public final class ProjectResponse implements Response {
    private final ProjectFuncionalitiesContainerDTO response;

    public ProjectResponse(ProjectFuncionalitiesContainerDTO response) {
        this.response = response;
    }

    public ProjectFuncionalitiesContainerDTO getResponse() {
        return this.response;
    }
}
