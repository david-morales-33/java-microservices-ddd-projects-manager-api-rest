package com.microservice.administrative.project.application.findFuncionalityProject;

import java.util.Optional;

import com.microservice.administrative.project.domain.ProjectFuncionalitiesContainer;
import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.project.domain.ProjectQueryRepository;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.Service;

@Service
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
