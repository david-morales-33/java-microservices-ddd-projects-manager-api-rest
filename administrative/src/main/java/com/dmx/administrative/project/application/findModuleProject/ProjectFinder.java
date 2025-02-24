package com.dmx.administrative.project.application.findModuleProject;

import com.dmx.administrative.project.domain.ProjectModulesContainer;
import com.dmx.administrative.project.domain.ProjectNotFound;
import com.dmx.administrative.project.domain.ProjectQueryRepository;
import com.dmx.administrative.shared.domain.ProjectId;

import java.util.Optional;

public final class ProjectFinder {
    private final ProjectQueryRepository queryRepository;

    public ProjectFinder(ProjectQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public ProjectModulesContainer execute(ProjectId projectId) throws ProjectNotFound {
        Optional<ProjectModulesContainer> response = this.queryRepository.findProjectModulesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("No se encontó el elemento");
        return response.get();
    }
}
