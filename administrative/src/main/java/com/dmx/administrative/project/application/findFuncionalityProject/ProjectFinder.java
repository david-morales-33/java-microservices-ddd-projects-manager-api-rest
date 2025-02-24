package com.dmx.administrative.project.application.findFuncionalityProject;

import com.dmx.administrative.project.domain.ProjectFuncionalitiesContainer;
import com.dmx.administrative.project.domain.ProjectNotFound;
import com.dmx.administrative.project.domain.ProjectQueryRepository;
import com.dmx.shared.domain.ProjectId;

import java.util.Optional;

public final class ProjectFinder {
    private final ProjectQueryRepository queryRepository;

    public ProjectFinder(ProjectQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public ProjectFuncionalitiesContainer execute(ProjectId projectId) throws ProjectNotFound {
        Optional<ProjectFuncionalitiesContainer> response = this.queryRepository.findProjectFuncionalitiesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("No se encontó el elemento");
        return response.get();
    }
}
