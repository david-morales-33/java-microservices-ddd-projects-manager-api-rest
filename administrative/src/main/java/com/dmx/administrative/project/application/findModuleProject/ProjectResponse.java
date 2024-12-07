package com.dmx.administrative.project.application.findModuleProject;

import com.dmx.administrative.project.domain.ProjectModulesContainerDTO;
import com.dmx.shared.domain.bus.query.Response;

public final class ProjectResponse implements Response {
    private final ProjectModulesContainerDTO response;

    public ProjectResponse(ProjectModulesContainerDTO response) {
        this.response = response;
    }

    public ProjectModulesContainerDTO getResponse() {
        return this.response;
    }
}
