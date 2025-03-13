package com.microservice.administrative.project.application.createModuleProject;

import java.util.HashMap;
import java.util.Optional;

import com.microservice.administrative.project.domain.ProjectAlreadyExists;
import com.microservice.administrative.project.domain.ProjectCommandRepository;
import com.microservice.administrative.project.domain.ProjectFuncionalitiesCounter;
import com.microservice.administrative.project.domain.ProjectModulesContainer;
import com.microservice.administrative.project.domain.ProjectName;
import com.microservice.administrative.project.domain.ProjectRoot;
import com.microservice.administrative.project.domain.ProjectRootRepository;
import com.microservice.administrative.shared.domain.ProjectId;

public final class ProjectCreator {
    private final ProjectCommandRepository commandRepository;
    private final ProjectRootRepository projectRootRepository;

    public ProjectCreator(ProjectCommandRepository commandRepository, ProjectRootRepository projectRootRepository) {
        this.commandRepository = commandRepository;
        this.projectRootRepository = projectRootRepository;
    }

    public void execute(ProjectId projectId, ProjectName projectName) {

        Optional<ProjectRoot> response = this.projectRootRepository.find(projectId);
        if (response.isPresent()) throw new ProjectAlreadyExists("El proyecto ya existe");

        ProjectModulesContainer project = ProjectModulesContainer.create(
                projectId,
                projectName,
                new ProjectFuncionalitiesCounter(0)
        );
        this.commandRepository.saveProjectModulesContainer(project);
    }
}
