package com.microservice.administrative.project.application.addModuleFuncionality;

import com.microservice.administrative.funcionality.domain.Funcionality;
import com.microservice.administrative.project.domain.ProjectCommandRepository;
import com.microservice.administrative.project.domain.ProjectModulesContainer;
import com.microservice.administrative.project.domain.ProjectNotFound;
import com.microservice.administrative.project.domain.ProjectQueryRepository;
import com.microservice.administrative.shared.domain.ModuleId;
import com.microservice.administrative.shared.domain.ProjectId;

import java.util.Optional;

public final class FuncionalityCreator {
    private final ProjectCommandRepository commandRepository;
    private final ProjectQueryRepository queryRepository;

    public FuncionalityCreator(
            ProjectCommandRepository commandRepository,
            ProjectQueryRepository queryRepository
    ) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public void execute(ProjectId projectId, ModuleId moduleId, Funcionality funcionality) {
        Optional<ProjectModulesContainer> response = this.queryRepository.findProjectModulesContainer(projectId);
        if (response.isEmpty()) throw new ProjectNotFound("No se encontró el proyecto solicitado");
        ProjectModulesContainer project = response.get();
        project.addFuncionality(moduleId, funcionality);
        this.commandRepository.saveProjectModulesContainer(project);
    }
}
