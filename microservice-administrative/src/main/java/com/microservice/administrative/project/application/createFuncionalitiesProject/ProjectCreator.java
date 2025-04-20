package com.microservice.administrative.project.application.createFuncionalitiesProject;

import java.util.Optional;

import com.microservice.administrative.project.domain.ProjectAlreadyExists;
import com.microservice.administrative.project.domain.ProjectCommandRepository;
import com.microservice.administrative.project.domain.ProjectFuncionalitiesContainer;
import com.microservice.administrative.project.domain.ProjectFuncionalitiesCounter;
import com.microservice.administrative.project.domain.ProjectName;
import com.microservice.administrative.project.domain.ProjectRoot;
import com.microservice.administrative.project.domain.ProjectRootRepository;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.shared.domain.Service;

@Service
public final class ProjectCreator {
    private final ProjectCommandRepository commandRepository;
    private final ProjectRootRepository projectRootRepository;

    public ProjectCreator(ProjectCommandRepository commandRepository, ProjectRootRepository projectRootRepository) {
        this.commandRepository = commandRepository;
        this.projectRootRepository = projectRootRepository;
    }

    public void execute(ProjectId projectId, ProjectName projectName) {

        Optional<ProjectRoot> response = this.projectRootRepository.find(projectId);
        if (response.isPresent()) throw new ProjectAlreadyExists("El projecto ya existe");

        ProjectFuncionalitiesContainer project = ProjectFuncionalitiesContainer.create(
                projectId,
                projectName,
                new ProjectFuncionalitiesCounter(0)
        );
        this.commandRepository.saveProjectFuncionalitiesContainer(project);
    }
}
