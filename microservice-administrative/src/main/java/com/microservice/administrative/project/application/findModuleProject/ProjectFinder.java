package com.microservice.administrative.project.application.findModuleProject;

import java.util.Optional;

import com.microservice.administrative.project.domain.ProjectModulesContainer;
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

    public ProjectModulesContainer execute(ProjectId projectId) throws ProjectNotFound {
        Optional<ProjectModulesContainer> response = this.queryRepository.findProjectModulesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("No se encontó el elemento");
        return response.get();
    }
}
