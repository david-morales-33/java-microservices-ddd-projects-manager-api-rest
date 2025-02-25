package com.microservice.administrative.project.application.addProjectFuncionality;

import com.microservice.administrative.funcionality.domain.Funcionality;
import com.microservice.administrative.project.domain.ProjectCommandRepository;
import com.microservice.administrative.project.domain.ProjectFuncionalitiesContainer;
import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.project.domain.ProjectQueryRepository;
import com.microservice.administrative.shared.domain.ProjectId;

import java.util.Optional;

public final class ProjectFuncionalityCreator {
    private final ProjectCommandRepository commandRepository;
    private final ProjectQueryRepository queryRepository;

    public ProjectFuncionalityCreator(
            ProjectCommandRepository commandRepository,
            ProjectQueryRepository queryRepository
    ) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public void execute(ProjectId projectId, Funcionality funcionality) {
        Optional<ProjectFuncionalitiesContainer> response = this.queryRepository.findProjectFuncionalitiesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("No se encontró el proyecto solicitado");
        ProjectFuncionalitiesContainer project = response.get();
        project.addFuncionality(funcionality);
        this.commandRepository.saveProjectFuncionalitiesContainer(project);
    }
}
