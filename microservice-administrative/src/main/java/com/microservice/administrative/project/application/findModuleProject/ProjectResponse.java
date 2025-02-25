package com.microservice.administrative.project.application.findModuleProject;

import com.microservice.administrative.project.domain.ProjectModulesContainerDTO;
import com.microservice.administrative.shared.domain.bus.query.Response;

public final class ProjectResponse implements Response {
    private final ProjectModulesContainerDTO response;

    public ProjectResponse(ProjectModulesContainerDTO response) {
        this.response = response;
    }

    public ProjectModulesContainerDTO getResponse() {
        return this.response;
    }
}
